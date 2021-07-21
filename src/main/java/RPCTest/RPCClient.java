package RPCTest;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient {
    public static void main(String[] args) throws IOException {
        MyInterface proxy = RPC.getProxy(MyInterface.class, 10086,
                new InetSocketAddress("127.0.0.1", 10927),
                new Configuration());

        String studentName = proxy.getNameByID("00000000");
        System.out.println(studentName);
        System.out.println(proxy.getNameByID("20210000000000"));
        System.out.println(proxy.getNameByID("20210123456789"));
        System.out.println(proxy.getNameByID("20210735010342"));
    }
}
