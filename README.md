# Producer

### PROJECT DEV REQUIREMENTS

- [JAVA 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven >= 3.6](https://maven.apache.org/)

# Git Hooks

- Git hooks are installed during maven build execution cycle. Git hook files, must be inside "config/hooks" folder at
  project root directory, with their respective name.

# Linting the project

- At the project root, execute the following command:

```sh
$ mvn pmd:pmd pmd:cpd
```

- After running pmd and cpd, the following reports will be generated: target/site/pmd.html and target/site/cpd.html

# Unit Tests

- At the project root, execute the following command:

```sh
$ mvn clean test
```

# Code Coverage

```sh
$ mvn clean test jacoco:report
```

Or just execute:

```sh
$ mvn clean test
```

- After running tests, the coverage report will be at the following folder: target/site/jacoco/index.html

# Wiremock

- At the project root, execute the following command to run the wiremock stub server application:

```sh
$ docker-compose -f config/wiremock/docker-compose.yml up
```

The wiremock server application will start listening at: http://localhost:8888

- To see all wiremock mapping, access: http://localhost:8888/__admin/mappings

## Resources

- [Wiremock Reference](http://wiremock.org/docs/getting-started/)

## Build with Maven

```sh
dev: mvn clean compile spring-boot:run
```

with profile

```sh
prod: mvn clean compile spring-boot:run -Pprod
```

## Kafka on Docker
 - Create Zookeeper and Kafka images 

```sh
docker-compose -f config/docker/kafka/docker-compose.yml up
```
 - Create new topic
```sh
docker exec -it kafka_kafka_1 kafka-topics.sh --create --bootstrap-server kafka:9092 --topic message.topic
```

- Acessar o container do kafka
```sh
docker exec -it kafka_kafka_1 bash
```

Listar kafka-topics
```sh
kafka-topics --list --bootstrap-server=localhost:9092
```

Describe kafka-topics
```sh
kafka-topics --bootstrap-server=localhost:9092 --topic=teste --describe
```

Acessando PRODUCER
```sh
kafka-console-producer --bootstrap-server=localhost:9092 --topic=teste
```
Acessando CONSUMER --from-beginning Indica ao consumer que deverá começar a ler do inicio do topic
```sh
kafka-console-consumer --bootstrap-server=localhost:9092 --topic=teste --from-beginning
```

Config Topic
```sh
kafka-topics.sh --zookeeper zookeeper:2181 --alter --topic teste --config retention.ms=1000
``` 