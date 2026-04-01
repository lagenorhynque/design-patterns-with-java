package design_patterns_with_java.scala.chapter02

trait Print2[A]:
  extension (a: A)
    def showWithParen(): Unit
    def showWithAster(): Unit

given Print2[Banner] with
  extension (b: Banner)
    def showWithParen(): Unit =
      b.showWithParen()

    def showWithAster(): Unit =
      b.showWithAster()

@main
def printBanner2Example() =
  // instance of type class with extension methods
  val b = new Banner("Hello")
  b.showWithParen()
  b.showWithAster()
