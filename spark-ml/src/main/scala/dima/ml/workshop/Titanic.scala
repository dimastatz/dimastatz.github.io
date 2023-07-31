package dima.ml.workshop

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{DoubleType, IntegerType}

object Titanic {
  def explore(session: SparkSession): Unit = {
    import session.sqlContext.implicits._

    val raw = session.sqlContext
      .read
      .option("sep", ",")
      .option("header", "true")
      .csv("/Users/dimastatz/Downloads/train.csv")

    raw.show(3, false)

    val df = raw.select(
      $"Age".cast(DoubleType).as("Age"),
      $"Pclass".cast(IntegerType).as("Pclass"),
      $"Survived".cast(IntegerType).as("Survived")
    )

    df.show(5)
    survivedByClass(session, df)
    survivedByAge(session, df)

  }

  def survivedByClass(session: SparkSession, df: DataFrame): DataFrame = {
    import session.sqlContext.implicits._
    val result = df.groupBy($"Pclass").avg("Survived")
    result.show(5)
    result
  }

  def survivedByAge(session: SparkSession, df: DataFrame) = {
    import session.sqlContext.implicits._
    import org.apache.spark.sql.functions.udf

    val func = udf( (age: Double) => createAgeGroup(age))

    val result = df
      .withColumn("AgeGroup", func($"Age"))
      .groupBy($"AgeGroup")
      .avg("Survived").as("Survived")
      .orderBy("avg(Survived)")

    result.show(5)
    result
  }

  def createAgeGroup(age: Double): String = age match {
    case x if x < 20 => "0-20"
    case x if x < 40 => "21-40"
    case x if x < 60 => "41-60"
    case _ => "60+"
  }

}
