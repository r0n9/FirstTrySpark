package vip.fanrong

object ScalaTest {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x))
      guess
    else
      sqrtIter((guess + x / guess) / 2, x)

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.0001
  def abs(x: Double) =
    if (x < 0) -x else x

  def sqrt1(x: Double): Double =
    sqrtIter(1, x)

  // 使用内部函数隐藏细节
  def sqrt2(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess))
        guess
      else
        sqrtIter((guess + x / guess) / 2)

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < 0.0001

    def abs(x: Double) =
      if (x < 0) -x else x

    sqrtIter(1)
  }

  def main(args: Array[String]) {
    println(sqrt1(2))
    println(sqrt2(2))
  }
}