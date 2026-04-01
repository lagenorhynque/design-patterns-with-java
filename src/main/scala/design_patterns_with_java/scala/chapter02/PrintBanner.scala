package design_patterns_with_java.scala.chapter02

trait Print:
  def showWithParen(): Unit
  def showWithAster(): Unit

class PrintBanner(string: String) extends Print:
  private val banner = new Banner(string)

  def showWithParen(): Unit =
    banner.showWithParen()

  def showWithAster(): Unit =
    banner.showWithAster()

@main
def printBannerExample() =
  // trait implementation by delegation
  val p: Print = new PrintBanner("Hello")
  p.showWithParen()
  p.showWithAster()
