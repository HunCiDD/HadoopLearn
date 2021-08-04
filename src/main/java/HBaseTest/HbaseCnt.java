package HBaseTest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.NamespaceNotFoundException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.ArrayList;

class HbaseCnt {
    private static Configuration conf;
    private static Connection conn;
    private static Admin admin;

    public void init() throws Exception {
        // 创建配置对象
        conf = HBaseConfiguration.create();
        // zookeeper 地址和端口
        conf.set("hbase.rootdir", "hdfs://localhost:9000/hbase");
        conf.set("hbase.zookeeper.quorum", "47.101.206.249:2181,47.101.216.12:2181,47.101.204.23:2181");
        // 创建连接
        conn = ConnectionFactory.createConnection(conf);
        // 创建admin
        admin = conn.getAdmin();
    }

    public void createNameSpace(String nameSpace) throws IOException {
        try {
            admin.getNamespaceDescriptor(nameSpace);
        }catch (NamespaceNotFoundException e) {
            //若发生特定的异常，即找不到命名空间，则创建命名空间
            NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(nameSpace).build();
            admin.createNamespace(namespaceDescriptor);
        }
    }

    public void createTable(String tableName, String[] colFamilies) throws Exception {
        // 创建表管理类
        TableName tName = TableName.valueOf(tableName);
        if (admin.tableExists(tName)) {
            System.out.println("table is exists!");
        } else {
            ArrayList<ColumnFamilyDescriptor> colFamilyList = new ArrayList<>();
            TableDescriptorBuilder tableDesBuilder = TableDescriptorBuilder.newBuilder(tName);
            for (String colFamily: colFamilies) {
                ColumnFamilyDescriptor colFamilyDes = ColumnFamilyDescriptorBuilder.newBuilder(colFamily.getBytes()).build();
                colFamilyList.add(colFamilyDes);
            }
            TableDescriptor tableDes = tableDesBuilder.setColumnFamilies(colFamilyList).build();
            admin.createTable(tableDes);
            System.out.println("table create success!");
        }
    }

    public void deleteTable(String tableName) throws Exception {
        TableName tName = TableName.valueOf(tableName);
        if (admin.tableExists(tName)) {
            admin.disableTable(tName);
            admin.deleteTable(tName);
        }
    }

    /*
    向某一行的某一列插入数据
    tableName: 表面
    rowKey：
    colFamily：
    colName：
    value
    */
    public static void insertRow(String tableName, String rowKey, String colFamily, String colName,
                                 String value) throws Exception {
        TableName tName = TableName.valueOf(tableName);
        Table table = conn.getTable(tName);
        Put put = new Put(rowKey.getBytes());
        put.addColumn(colFamily.getBytes(), colName.getBytes(), value.getBytes());
        table.put(put);
        table.close();
    }

    public static void deleteRow(String tableName, String rowKey) throws Exception {

    }

}
