package vip.fanrong

import java.io._
import scala.io.Source

object FileWriteAndRead extends App {
  val file = new File("C:\\scala_write.txt")
  def writeTest() = {
    val writer = new PrintWriter(file)
    writer.write("Hello Scala! \n")
    writer.write("Hello Scala2 \n")

    writer.close()
  }

  def readFile() = {
    println("文件内容为:")
    val buffer = Source.fromFile(file)
    buffer.foreach(print)
    buffer.close()
  }

  writeTest()
  readFile()
  println(file.delete())

}