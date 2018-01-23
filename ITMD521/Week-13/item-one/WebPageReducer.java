import java.io.*;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class URLReducer extends Reducer<Text, Text, Text, Text> {
	public static String sort(ArrayList <String> list){
		String max = null;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0; i < list.size(); i++){
			if(map.get(list.get(i)) == null){
				map.put(list.get(i),1);
			}else{
				map.put(list.get(i), map.get(list.get(i)) + 1);
			}
		}
		int largest = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if( value > largest){
				largest = value;
			}
		}
		ArrayList<Object> arr = new ArrayList<Object>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if( value == largest){
				arr.add(key);
				for (int k =0 ; k < arr.size(); k++){
					max = (String) arr.get(k);
					
				}
			}
		}
		return max;
	}

	public void reduce(Text key, Iterable<Text> vals, Context context) throws IOException, InterruptedException {
		String max = null;
		ArrayList<String> webpage = new ArrayList<String>();
		for (Text value : vals){
     		webpage.add(value.toString());
    	}

        max=sort(webpage);

    	context.write(key, new Text(max));
	}
}