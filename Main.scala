package br.com.semantix.nasa

import org.apache.spark._
import org.apache.spark.SparkContext._

case class Request(host: String, timestamp: String, endpoint: String, statusCode: Int, requestLength: Long)

object Main {
  def main(args: Array[String]) {
    //val dataSet = sc.textFile("logs/NASA_access_log_A*.gz")
    //val regex = """(.*) - - [(.*)] "(.*)" (\d)+ (\d)+""".r
  }
}
