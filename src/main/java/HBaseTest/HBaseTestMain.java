package HBaseTest;
import java.util.HashMap;


public class HBaseTestMain {

    public static void main(String[] args)throws Exception{
        String nameSpace = "HuangDongDong";
        String tableName = "HuangDongDong:HDD_student";
        String[] columnFamily = {"info", "score"};
        HbaseCnt cnt = new HbaseCnt();
        cnt.init();
//        cnt.createNameSpace(nameSpace);
//        cnt.createTable(tableName, columnFamily);

        // 插入数据
//        cnt.insertRow(tableName, "Tom", "info", "student_id", "2021000000000001");
//        cnt.insertRow(tableName, "Tom", "info", "class", "1");
//        cnt.insertRow(tableName, "Tom", "score", "understanding", "75");
//        cnt.insertRow(tableName, "Tom", "score", "programming", "82");

        // 查询数据
//        cnt.queryRow(tableName, "Tom");
        // 删除数据
        cnt.deleteRow(tableName, "Tom");

    }


}
