package WordCount
import org.apache.spark.{SparkConf, SparkContext}

object WordCountMain {
  def main(args: Array[String]): Unit = {
    // 启动本地化计算
    val conf = new SparkConf().setMaster("local").setAppName("WordCount2")
    // 开始
    val sc = SparkContext.getOrCreate(conf)

    val emptyRDD = sc.emptyRDD[(String, String)]
    var filePath = "src/main/scala/WordCount/".concat("0.txt")
    var r00 = sc.textFile(filePath).flatMap(x => x.split(" "))
    var r01 = r00.map(x => (x, "0.txt")).distinct()     // 转换为 (word, file_name)
    var r02 = r00.map(x => (x, 1)).reduceByKey(_+_)     // 转换为 (word, number)
    var r03 = r01.join(r02)                             // 转换为（word，(file_name, number)）
    // --------------
    filePath = "src/main/scala/WordCount/".concat("1.txt")
    var r10 = sc.textFile(filePath).flatMap(x => x.split(" "))
    var r11 = r10.map(x => (x, "1.txt")).distinct()
    var r12 = r10.map(x => (x, 1)).reduceByKey(_+_)
    var r13 = r11.join(r12)
    // --------------
    filePath = "src/main/scala/WordCount/".concat("2.txt")
    var r20 = sc.textFile(filePath).flatMap(x => x.split(" "))
    var r21 = r20.map(x => (x, "2.txt")).distinct()
    var r22 = r20.map(x => (x, 1)).reduceByKey(_+_)
    var r23 = r21.join(r22)

    var r8 = r03.union(r13)                             // 将多个文件对应rdd合并（word，(file_name, number)）
    var r9 = r8.union(r23).groupByKey().sortByKey()     // 将rdd分组，排序（word，[(file_name, number), (file_name, number)]）
    r9.collect().foreach(println)
  }
}
