package vip.fanrong

object Test2 {
  def main(args: Array[String]) {
    println(cube(3))

    println(sumCube(1, 5))
    println(sum1(n => n * n * n)(1, 5))
    println(sum2(n => n * n * n)(1)(5))
    println(sum3(n => n * n * n, 1, 5))

    println(sum1(n => cube(n))(1, 5))

    val list = List(1, 2, 3, 4, 5)
    println("list.head: " + list.head)
    println("list.tail: " + list.tail)
    
    println("before fold: " + list)
    println(list.foldLeft(0)((x0, x) => x0 + x))
    println("after fold: " + list)
  }

  def cube(n: Int) = n * n * n

  def sumCube(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCube(a + 1, b)

  // 高阶函数 Higher-Order Function
  def sum(fun: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else fun(a) + sum(fun, a + 1, b)
  }

  def sumCube1(a: Int, b: Int): Int = sum(cube, a, b)

  // 高阶函数中使用匿名函数
  def sumCube2(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

  // 柯里化 Currying 高阶函数
  def sum(fun: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else fun(a) + sumF(a + 1, b)
    sumF
  }

  // 使用语法糖后的 sum 函数
  def sum1(fun: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else fun(a) + sum1(fun)(a + 1, b)

  def sum2(fun: Int => Int)(a: Int)(b: Int): Int =
    if (a > b) 0 else fun(a) + sum2(fun)(a + 1)(b)

  def sum3(fun: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else fun(a) + sum3(fun, a + 1, b)
}