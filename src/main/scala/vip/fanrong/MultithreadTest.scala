package vip.fanrong

import java.util.concurrent._

object MultithreadTest {

  def main(args: Array[String]) {
    val barrier = new CyclicBarrier(5, new Runnable() { override def run() { println("CyclicBarrier!!!") } })

    for (i <- 1 to 5) {
      val threadDemo = new ThreadDemo("Thread[" + i + "]", barrier)
      new Thread(threadDemo).start()
    }
  }

  class ThreadDemo(threadName: String, barrier: CyclicBarrier) extends Runnable {
    override def run() {
      for (i <- 1 to 10) {
        if (i == 4) barrier.await()
        println(threadName + ": " + i)
        Thread.sleep(1000)
      }
    }
  }
}