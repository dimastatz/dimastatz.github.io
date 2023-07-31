package dima.ml.workshop

import org.apache.spark.sql.SparkSession

object Boot {
  def main(args: Array[String]): Unit = {
    println("starting spark")

    val session = SparkSession
      .builder()
      .appName("normalizer")
      .master("local[*]")
      .getOrCreate()

    //Titanic.explore(session)


    // malicious domains classifier
    MaliciousDomains.run(session)
  }
}
