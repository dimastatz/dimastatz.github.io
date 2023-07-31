name := "ml-workshop"
version := "0.1"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "org.apache.spark" %% "spark-mllib" % "2.1.0",
  "org.apache.spark" %% "spark-sql" % "2.1.0",
  "org.apache.hadoop" % "hadoop-aws" % "2.7.3",
  "org.apache.hadoop" % "hadoop-hdfs" % "2.7.3",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.librato.metrics" % "metrics-librato" % "5.0.0",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.0"

).map(_.exclude("org.slf4j", "*"))

//insert one without exclusion
libraryDependencies ++= Seq(
  "org.slf4j" % "jul-to-slf4j" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)