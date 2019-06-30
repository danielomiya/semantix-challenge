# Questionário

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
