package QuickStart

import org.apache.spark.sql.SparkSession

object sparkQuickStart extends App {
  val spark = SparkSession
    .builder()
    .master("spark://172.19.0.5:7077")
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

}
