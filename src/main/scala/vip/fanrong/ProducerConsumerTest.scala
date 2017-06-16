package vip.fanrong

import java.util.concurrent._

object ProducerConsumerTest {
  def main(args: Array[String]) {
    val queue = new ArrayBlockingQueue[String](10)

    new Thread(new Producer(queue, "Karl")).start();
    new Thread(new Producer(queue, "Fiona")).start();

    new Thread(new Consumer(queue, "Frank")).start();
    new Thread(new Consumer(queue, "FrankKKK")).start();
  }

  class Producer(queue: ArrayBlockingQueue[String], producerName: String) extends Runnable {
    override def run() = {
      var count = 1
      while (true) {
        queue.put(producerName + "[" + count + "]")
        count += 1

        if ("Karl".equals(producerName))
          Thread sleep 2000 + count * 10
          
        if ("Fiona".equals(producerName))
          Thread sleep 1000
      }
    }
  }

  class Consumer(queue: ArrayBlockingQueue[String], consumerName: String) extends Runnable {
    override def run() = {
      var count = 1
      while (true) {
        println("-- Consumer queue = " + queue.size())
        println("-- Consumer " + consumerName + " takes " + queue.take())
        Thread sleep 4000
      }
    }
  }

}