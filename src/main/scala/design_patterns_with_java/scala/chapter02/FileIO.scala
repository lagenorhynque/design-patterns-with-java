package design_patterns_with_java.scala.chapter02

import java.io.{ FileInputStream, FileOutputStream }
import java.util.Properties

trait FileIO:
  def readFromFile(filename: String): Unit
  def writeToFile(filename: String): Unit
  def setValue(key: String, value: String): Unit
  def getValue(key: String): String

class FileProperties extends FileIO:
  private val properites = new Properties

  def readFromFile(filename: String): Unit =
    properites.load(new FileInputStream(filename))

  def writeToFile(filename: String): Unit =
    properites.store(new FileOutputStream(filename), "written by FileProperties")

  def setValue(key: String, value: String): Unit =
    properites.setProperty(key, value)

  def getValue(key: String): String =
    properites.getProperty(key)

@main
def fileIOExample() =
  // trait implementation by delegation
  val f: FileIO = new FileProperties
  f.readFromFile("file.txt")
  f.setValue("month", "4")
  f.setValue("day", "21")
  f.writeToFile("newfile1.txt")
  f.setValue("year", "2004")
  f.writeToFile("newfile2.txt")
