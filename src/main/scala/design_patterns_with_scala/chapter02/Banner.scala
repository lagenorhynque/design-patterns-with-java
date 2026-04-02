package design_patterns_with_scala.chapter02

class Banner(string: String):
  def showWithParen(): Unit =
    println(s"($string)")

  def showWithAster(): Unit =
    println(s"*$string*")
