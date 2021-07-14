package PhoneData;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PhoneDataReducer extends Reducer<Text, FlowBean, Text, String> {
    // 输出值
    private FlowBean result = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context)
            throws IOException, InterruptedException {
        long sumUpFlow = 0;
        long sumDownFlow = 0;
        for (FlowBean val : values) {
            sumUpFlow += val.getUpFlow();
            sumDownFlow += val.getDownFlow();
        }
        result.set(sumUpFlow, sumDownFlow);
        context.write(key, result.toString());
    }
}
