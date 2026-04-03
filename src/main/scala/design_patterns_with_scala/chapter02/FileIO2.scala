package design_patterns_with_scala.chapter02

import java.io.{FileInputStream, FileOutputStream}
import java.util.Properties

trait FileIO2[A]:
  extension (a: A)
    def readFromFile(filename: String): Unit
    def writeToFile(filename: String): Unit
    def setValue(key: String, value: String): Unit
    def getValue(key: String): String

given FileIO2[Properties] with
  extension (p: Properties)
    def readFromFile(filename: String): Unit =
      p.load(new FileInputStream(filename))

    def writeToFile(filename: String): Unit =
      p.store(new FileOutputStream(filename), "written by FileProperties")

    def setValue(key: String, value: String): Unit =
      p.setProperty(key, value)

    def getValue(key: String): String =
      p.getProperty(key)

@main
def fileIO2Example() =
  // instance of type class with extension methods
  val p = new Properties
  p.readFromFile("file.txt")
  p.setValue("month", "4")
  p.setValue("day", "21")
  p.writeToFile("newfile1.txt")
  p.setValue("year", "2004")
  p.writeToFile("newfile2.txt")
