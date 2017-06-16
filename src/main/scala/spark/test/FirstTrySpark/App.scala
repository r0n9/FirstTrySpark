package spark.test.FirstTrySpark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author ${user.name}
 */
object App {

  def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\winutils")

    println("Hello World!")
    println("concat arguments = " + foo(args))

    val conf = new SparkConf();
    conf.setMaster("local")
    conf.setAppName("first-tryspark")
    val sc = new SparkContext(conf)
    val rawblocks = sc.textFile("C:/eula.1028.txt")

    val counts = rawblocks.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
    counts.saveAsTextFile("C:/eula.1028.result.txt")

  }

}
