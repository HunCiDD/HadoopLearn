package HBaseTest;


public class HBaseTestMain {

    public static void main(String[] args)throws Exception{
        String tableName = "HDD_G20210735010342_01:student";
        String[] columnFamily = {"info", "score"};
        HbaseCnt cnt = new HbaseCnt(args[0], args[1]);
        cnt.init();
        cnt.createTable(tableName, columnFamily);
    }

}
