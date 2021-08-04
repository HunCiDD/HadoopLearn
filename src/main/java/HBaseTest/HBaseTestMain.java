package HBaseTest;


public class HBaseTestMain {

    public static void main(String[] args)throws Exception{
        String nameSpace = "HuangDongDong";
        String tableName = "HuangDongDong:HDD_student";
        String[] columnFamily = {"info", "score"};
        HbaseCnt cnt = new HbaseCnt();
        cnt.init();
        cnt.createNameSpace(nameSpace);
        cnt.createTable(tableName, columnFamily);
    }

}
