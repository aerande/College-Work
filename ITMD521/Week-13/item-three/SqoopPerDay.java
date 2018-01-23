import java.io.*;

import com.cloudera.sqoop.lib.RecordParser.ParseError;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;

public class SqoopPerDay extends Configured implements Tool {

  public static class SqoopPerDayMapper
      extends Mapper<LongWritable, Text, Text, Text> {

    //private Log maxWidget = null;

    public void map(LongWritable k, Text v, Context context) {
      Log log = new Log();
      String day=null, status=null, webpage=null;
      try {
        log.parse(v); // Auto-generated: parse all fields from text.
        day = log.get_date_day();
        status = log.get_sc_status();
        if (status.matches("200") && !log.get_cs_uri_stem().matches("index.")) {
          webpage = log.get_cs_uri_stem();
          context.write(new Text(day), new Text(webpage));
        }
      }
      catch (Exception pe) {
        // Got a malformed record. Ignore it.
        return;
      }
    } 


  }
  
  public static class SqoopPerDayReducer
    extends Reducer<Text, Text, LongWritable, Text> {
  // There will be a single reduce call with key '0' which gets
  // the max log from each map task. Pick the max log from
  // this list.
  public void reduce(LongWritable k, Iterable<Text> vals, Context context)
      throws IOException, InterruptedException {
    //Log maxWidget = null;
    // String webpage = null;
    String value = null;

    for (Text w : vals) {
      try{
        value = w.toString();
      }
      catch(Exception cnse){

      }
    }
    if(value!=null){
      context.write(k, new Text(value));
    }
    
  }
}

public int run(String [] args) throws Exception {
  Job job = new Job(getConf());

  job.setJarByClass(SqoopPerDay.class);

  job.setMapperClass(SqoopPerDayMapper.class);
  job.setReducerClass(SqoopPerDayReducer.class);

  FileInputFormat.addInputPath(job, new Path("logs"));
  FileOutputFormat.setOutputPath(job, new Path("logperday"));

  job.setMapOutputKeyClass(LongWritable.class);
  job.setMapOutputValueClass(Log.class);

  job.setOutputKeyClass(Log.class);
  job.setOutputValueClass(NullWritable.class);

  job.setNumReduceTasks(1);

  if (!job.waitForCompletion(true)) {
      return 1; // error.
  }

  return 0;
}

public static void main(String [] args) throws Exception {
    int ret = ToolRunner.run(new SqoopPerDay(), args);
    System.exit(ret);
  }
}