package vip.fanrong

import util.control.Breaks._

object LoopOps {

  def main(args: Array[String]) = {
    val list = List(21, 214, -4352, 65436, 7534)

    breakTest1(list)
    breakTest2(list)

    contniueTest1(list)
    continueTest2(list)

    continueTest3(list)

  }

  def breakTest1(list: List[Int]) = {
    println("breakable语句块来实现break操作")
    breakable {
      for (elem <- list)
        if (elem < 0) break else println(elem)
    }
  }

  def breakTest2(list: List[Int]) = {
    println("增加一个boolean变量作为for循环守卫，while循环同理")
    var foundMinus = false
    for (elem <- list if !foundMinus) {
      if (elem < 0) foundMinus = true else println(elem)
    }
  }

  def contniueTest1(list: List[Int]) = {
    println("breakable语句块来实现continue操作")
    for (elem <- list)
      breakable {
        if (elem < 0) break else println(elem)
      }
  }

  def continueTest2(list: List[Int]) = {
    println("if else控制来实现continue操作")
    for (elem <- list)
      if (elem < 0) () else println(elem)
  }

  def continueTest3(list: List[Int]) = {
    println("递归函数重写循环")
    def next(i: Int): Unit = {
      if (i >= list.size) Unit
      else if (list(i) < 0) next(i + 1)
      else println(list(i)); next(i + 1)
    }

    next(0)

  }
}