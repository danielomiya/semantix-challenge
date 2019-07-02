# Semantix Challenge

Simple project proposed for a selection process.

The details of the challenge can be found [here](Desafio%20Engenheiro%20de%20Dados.pdf), and the answers, [here](questions.md).

## Built with

- OpenJDK (1.8.0_212)
- Apache Spark (2.4.3)
- Scala (2.11.12)

## How to get it running

- Clone it `git clone https://github.com/gwyddie/semantix-challenge.git`
- Change directory `cd semantix-challenge`
- Run it `spark-shell -i Main.scala`

## How it works

The script written in Scala will search the `logs/` directory for logs, and then match lines with the following RegExp:

<!-- is there a nice way to put a RegExp in a markdown file? -->
```javascript
/^(.*)\s-\s-\s\[(.*)\]\s"(\w*)\s(.*)"\s(\d+)\s?(\d+|-)$/
```

Any line that does not follow such pattern is ignored.

After that, it maps the nice lines to a `case class`, but then all it does is boring calculation, that you can check out at the [script](Main.scala).

## Example of use

The directory `logs/*` is where the logs live. By putting 'NASA logs' there, the script will find them, read, evaluate and then print results for the following statistics:

- amount of unique hosts
- total of 404 errors
- most 404 throwing URLs
- amount of 404 erros per day
- total of returned bytes

That's all, folks!

Thanks ;)
