//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package WordCount;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMapper extends Mapper<Object, Text, Text, IntWritable> {
    public static final IntWritable ONE = new IntWritable(1);
    public static Text word = new Text();

    public WordMapper() {
    }

    protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        StringTokenizer stringTokenizer = new StringTokenizer(((Text)context.getCurrentValue()).toString());

        while(stringTokenizer.hasMoreTokens()) {
            word.set(stringTokenizer.nextToken());
            context.write(word, ONE);
        }

    }
}
