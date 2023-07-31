package dima.ml.workshop

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MaliciousDomains {
  def loadDomains(session: SparkSession) = {
    import session.sqlContext.implicits._

    session.sqlContext.read.option("sep", ",")
      .csv("/Users/dimastatz/Documents/dev/ml-workshop/resources/benign_fqdns.txt")
      .toDF("domain")
      .withColumn("malicious", lit(0))
  }

  def loadMaliciousDomains(session: SparkSession) = {
    session.sqlContext.read.option("sep", ",")
      .csv("/Users/dimastatz/Documents/dev/ml-workshop/resources/malicious_fqdns.txt")
      .toDF("domain")
      .withColumn("malicious", lit(1))

  }

  def run(session: SparkSession) = {
    val rawDf = loadDomains(session)
      .union(loadMaliciousDomains(session))

    val df = rawDf
      .withColumn("dotsNumber", lit(rawDf("domain").toString.split('.').length))
      .withColumn("nameLength", lit(rawDf("domain").toString.length))


    df.printSchema()
    df.show(5)

  }

}
