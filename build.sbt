lazy val root = (project in file("."))
  .settings(
    name := "design-patterns-with-java",
    version := "0.1.0",
    scalaVersion := "3.8.2",
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")
  )
