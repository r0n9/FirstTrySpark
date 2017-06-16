package vip.fanrong

import org.apache.hadoop.conf._;
import org.apache.hadoop.fs._

import scala.io.Source

object HDFSTest {
  def main(args: Array[String]) = {
    val conf = new Configuration
    conf.addResource("core-site.xml")
    conf.addResource("hdfs-site.xml")
    val fileSystem = FileSystem.get(conf)
    val fSDataInputStream = fileSystem.open(new Path("hdfs://ubuntu-host-01:9000/test/INSTALL.LOG"))

    val buffer = Source.fromInputStream(fSDataInputStream)
    buffer.getLines().foreach(println)
    buffer.close()
  }
}