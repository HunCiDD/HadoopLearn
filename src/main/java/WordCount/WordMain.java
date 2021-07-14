package WordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordMain {
    public WordMain() {
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        Job job = Job.getInstance(conf);
        job.setJarByClass(WordMain.class);
        job.setJobName("HuangDongDongTask");
        new Path("xxx");
        Path outfile = new Path("xxx2");
        if (outfile.getFileSystem(conf).exists(outfile)) {
            outfile.getFileSystem(conf).delete(outfile, true);
        }

        TextOutputFormat.setOutputPath(job, outfile);
        job.setMapperClass(WordMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(WordReducer.class);
        job.waitForCompletion(true);
    }
}
