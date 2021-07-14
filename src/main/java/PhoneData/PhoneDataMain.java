package PhoneData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class PhoneDataMain {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        // 创建job和任务入口
        Job job = Job.getInstance(conf);
        // 运行MapReduce的是哪一个Jar包
        job.setJarByClass(WordCount.WordMain.class);      // main方法所在的class
        job.setJobName("HuangDongDongTask");

        // 用于Map作业的是哪一个类
        // 标识Map输出的K，V对应的class，方便Reduce端反序列化
        job.setMapperClass(PhoneDataMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        // 指定job的Reduce作业是哪一个类
        // 指定job的Reduce的输出类型<k4, v4>
        job.setReducerClass(PhoneDataReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(String.class);

        // 指定job的输入和输出
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 执行job
        job.waitForCompletion(true);

    }
}
