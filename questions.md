# Questões

- Qual o objetivo do comando **cache** em Spark?

  Como o nome sugere, o comando **cache** serve para fazer _caching_. Quando um RDD será usado para realizar mais de uma ação, é necessário explicitar que ele deve ser mantido em _cache_, assim, o Spark não irá recriá-lo do zero para cada uma dessas ações.

- O mesmo código implementado em Spark é normalmente mais rápido que a implementação equivalente em MapReduce. Por quê?

  Porque o Hadoop MapReduce faz um processamento por _batch_ em disco, enquanto que o Spark faz o processamento de dados na memória principal, diminuindo a quantidade de operações desnecessárias na memória secundária.

- Qual é a função do SparkContext?

  O `SparkContext` permite a criação de RDDs, _accumulators_ e a transmissão de variáveis pelo _cluster_, além de ser responsável por fazer os RDDs resilientes e distribuídos.

- Explique com suas palavras o que é o Resilient Distributed Datasets (RDD).

  RDDs são conjuntos de dados resilientes a erros distribuídos em um ou vários _clusters_.

- groupByKey é menos eficiente que reduceByKey em grandes datasets. Por quê?

  Porque quando o `groupByKey` é invocado ele transmite os dados diretamente pela rede, comportamento que difere do `reduceByKey`, que aplica um _reducer_, ou seja, 'reduz' a quantidade de dados antes de realizar tal transmissão.

- Explicação do código

```scala
val textFile = sc.textFile("hdfs://...")
val counts = textFile.flatMap(line => line.split(" "))
  .map(word => (word, 1))
  .reduceByKey(_ + _)

counts.saveAsTextFile("hdfs://...")
```

Por linhas:
1. `SparkContext` é usado para criar um RDD
1. Mapeia todas as palavras do arquivo para um `Array[String]`
1. Mapeia essas palavras para um `Tuple2[String, Int]`
1. Reduz as tuplas, sendo o resultado outra `Tuple2[String, Int]`, com `_1` sendo a palavra, e `_2` a quantidade de vezes que essa palavra repete.
1. \# linha em branco
1. Salva o resultado gerado como arquivo de texto

## HTTP requests to the NASA Kennedy Space Center WWW server

1. Número de _hosts_ únicos

   137978 hosts únicos

1. O total de erros 404

   20901 erros

1. Os 5 URLs que mais causaram erros 404

   # | URL                                          | Qtd
   --|----------------------------------------------|-----
   1 | /pub/winvn/readme.txt                        | 2004
   2 | /pub/winvn/release.txt                       | 1732
   3 | /shuttle/missions/STS-69/mission-STS-69.html | 683
   4 | /shuttle/missions/sts-68/ksc-upclose.gif     | 428
   5 | /history/apollo/a-001/a-001-patch-small.gif  | 384

1. Quantidade de erros 404 por dia

   Data        | Qtd
   ------------|----
   01/Jul/1995 | 316
   02/Jul/1995 | 291
   03/Jul/1995 | 474
   04/Jul/1995 | 359
   05/Jul/1995 | 497
   06/Jul/1995 | 640
   07/Jul/1995 | 570
   08/Jul/1995 | 302
   09/Jul/1995 | 348
   10/Jul/1995 | 398
   11/Jul/1995 | 471
   12/Jul/1995 | 471
   13/Jul/1995 | 532
   14/Jul/1995 | 413
   15/Jul/1995 | 254
   16/Jul/1995 | 257
   17/Jul/1995 | 406
   18/Jul/1995 | 465
   19/Jul/1995 | 639
   20/Jul/1995 | 428
   21/Jul/1995 | 334
   22/Jul/1995 | 192
   23/Jul/1995 | 233
   24/Jul/1995 | 328
   25/Jul/1995 | 461
   26/Jul/1995 | 336
   27/Jul/1995 | 336
   28/Jul/1995 | 94
   01/Aug/1995 | 243
   03/Aug/1995 | 304
   04/Aug/1995 | 346
   05/Aug/1995 | 236
   06/Aug/1995 | 373
   07/Aug/1995 | 537
   08/Aug/1995 | 391
   09/Aug/1995 | 279
   10/Aug/1995 | 315
   11/Aug/1995 | 263
   12/Aug/1995 | 196
   13/Aug/1995 | 216
   14/Aug/1995 | 287
   15/Aug/1995 | 327
   16/Aug/1995 | 259
   17/Aug/1995 | 271
   18/Aug/1995 | 256
   19/Aug/1995 | 209
   20/Aug/1995 | 312
   21/Aug/1995 | 305
   22/Aug/1995 | 288
   23/Aug/1995 | 345
   24/Aug/1995 | 420
   25/Aug/1995 | 415
   26/Aug/1995 | 366
   27/Aug/1995 | 370
   28/Aug/1995 | 410
   29/Aug/1995 | 420
   30/Aug/1995 | 571
   31/Aug/1995 | 526

1. O total de _bytes_ retornados

   6.5524314915E10 _bytes_
