package QuickStart
import org.apache.spark.sql.SparkSession

// Self-contained application
object sparkQuickStart extends App {
  val spark = SparkSession
    .builder()
    .master("spark://172.19.0.5:7077")
    .appName("Spark - Quick Start")
    //.config("spark.some.config.option", "some-value")
    .getOrCreate()
  val logFile = "/opt/workspace/data/README.md"
  val logData = spark.read.textFile(logFile).cache()
  val numAs = logData.filter(line => line.contains("a")).count()
  val numBs = logData.filter(line => line.contains("b")).count()
  println(s"Lines with a: $numAs, Lines with b: $numBs")
  // Spark’s primary abstraction is a distributed collection of items called a Dataset. Datasets can be created from
  // Hadoop InputFormats (such as HDFS files) or by transforming other Datasets.

}
