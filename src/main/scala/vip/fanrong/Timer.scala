package vip.fanrong

object Timer extends App {
  def oncePerSecond(callback: () => Unit) =
    while (true) { callback(); Thread sleep (1000) }

  def printTimeFlies() =
    println("time flies like an arrow...")

  oncePerSecond(printTimeFlies)
}