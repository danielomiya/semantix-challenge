case class Request(
  host: String,
  datetime: String,
  method: String,
  path: String,
  statusCode: String,
  contentLength: String)

val pattern = """^(.*)\s-\s-\s\[(.*)\]\s"(\w*)\s(.*)"\s(\d+)\s?(\d+|-)$""".r

def extract(value: String): Option[Request] = {
  pattern.findFirstIn(value) match {
    case Some(pattern(_1, _2, _3, _4, _5, _6)) => Option(Request(_1, _2, _3, _4.split(" ")(0), _5, if (_6 == "-") "0" else _6))
    case _ => None
  }
}

sc.setLogLevel("ERROR")

val logs = sc.textFile("logs/*")
val records = logs.map(extract).filter(!_.isEmpty).map(_.get).cache // this is ugly, but it works
val uniqueHosts = records.map(_.host).distinct.count

println

println("Quantidade de hosts únicos: " + uniqueHosts) // 137978
println

val errors404 = records.filter(_.statusCode.contains("404"))
println("Quantidade de erros 404: " + errors404.count)
println

println("Top 5 URLs com mais erros 404:")
errors404
  .map(x => (x.path, 1))
  .reduceByKey(_ + _)
  .sortBy(_._2, false)
  .take(5)
  .foreach(x => println(x._1 + ": " + x._2))
println

println("Erros 404 por dia:")
errors404
  .map(x => (x.datetime.split(":")(0), 1))
  .reduceByKey(_ + _)
  .collect
  .foreach(x => println(x._1 + ": " + x._2))
println

val sentBytes = records
  .filter(_.contentLength != "-")
  .map(_.contentLength.toLong)
  .sum
println("Bytes enviados: " + sentBytes)

System.exit(0) // termina o REPL
