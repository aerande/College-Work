import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WebPagePerDayMapper extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String [] words = null;
		String month=null, quality=null, webpage=null;
		try{
			words = line.split("\\s");
    		month = words[2];
    		quality = words[15];
			webpage = words[9];
    		if (quality.matches("200") && !webpage.matches("index.")) {
   				context.write(new Text(month), new Text(webpage));  
			}
		}
		catch(Exception e){
	 		e.printStackTrace();
		}
	}
}