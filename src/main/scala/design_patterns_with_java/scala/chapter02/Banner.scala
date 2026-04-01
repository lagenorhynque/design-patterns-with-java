package design_patterns_with_java.scala.chapter02

class Banner(string: String):
  def showWithParen(): Unit =
    println(s"($string)")

  def showWithAster(): Unit =
    println(s"*$string*")
