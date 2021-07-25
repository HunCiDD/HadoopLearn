package RPCTest;
import java.util.HashMap;
import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;


public class RPCServer implements MyInterface{

    @Override
    public String getNameByID(String ID) {
        // 创建 HashMap 对象 Sites
        HashMap<String, String> studentInfos = new HashMap<String, String>();
        // 添加键值对
        studentInfos.put("20210000000000", "null");
        studentInfos.put("20210123456789", "心心");
        studentInfos.put("20210735010342", "黄冬冬");
        System.out.printf("Client 请求学号ID%s", ID);
        return studentInfos.getOrDefault(ID, "Not Found");
    }

    public static void main(String[] args) throws HadoopIllegalArgumentException, IOException{
        Server server = new RPC.Builder(new Configuration())
                .setInstance(new RPCServer())
                .setBindAddress("127.0.0.1")
                .setPort(10927)
                .setProtocol(MyInterface.class)
                .build();
        server.start();
    }
}
