package PhoneData;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class PhoneDataMapper extends Mapper<Object, Text, Text, Writable> {
    public static Text word = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        /*
        背景：
            1-在Map阶段，针对每个文件块建立一个map任务，map任务直接运行在DataNode上，即移动计算，而非数据，
            2-每个map任务处理自己的文件块，然后输出新的键值对。
        输入：
            1-Object key：每行文件的偏移量。
            2-Text value：每行文件的内容。
            3-Context context：Map端的上下文。
        故map函数需要在context中输出，key，value
        */

        // 遍历当前所有内容，使用StringTokenizer进行分割字符串
        /*
        1. StringTokenizer(String str) ：
        构造一个用来解析 str 的 StringTokenizer 对象。java 默认的分隔符是空格("")、制表符(\t)、换行符(\n)、回车符(\r)。
        2. StringTokenizer(String str, String delim) ：
        构造一个用来解析 str 的 StringTokenizer 对象，并提供一个指定的分隔符。
         */
        String all = context.getCurrentValue().toString();
        // 按照行进行分割
        String lines[] = all.split("\\r?\\n");
        for (String line: lines){
            String fields[] = line.split("\t");
            String phoneNumber = fields[1];
            int length = fields.length;
            if ( length < 3 ) {
                continue;
            }
            long upFlow = Long.parseLong(fields[length-3]);
            long downFlow = Long.parseLong(fields[length-2]);
            FlowBean flowBean = new FlowBean(upFlow, downFlow);
            word.set(phoneNumber);
            // 序列化写
            context.write(word, flowBean);
        }
    }
}

