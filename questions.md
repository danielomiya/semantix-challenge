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
