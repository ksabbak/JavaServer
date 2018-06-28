[![CircleCI](https://circleci.com/gh/ksabbak/JavaServer.svg?style=svg)](https://circleci.com/gh/ksabbak/JavaServer)
# Java HTTP Server

An HTTP server built in Java 8, with all the basic functionality for a simple CRUD app with an example CRUD app. The example app is based on the acceptance criteria in [cob_spec](https://github.com/ksabbak/cob_spec/tree/96e09c3c9641a7f60e77f10f15e5abfeffa8ca93).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Requirements

* JDK SE 8 ([Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* Gradle ([Installation instructions](https://gradle.org/install/))


### Installing

After getting JDK SE 8 and Gradle working, navigate to the directory and run
```
$ gradle run
```

And you're set. Your server will now accept requests sent to [port 5000](http://localhost:5000/)

## Running the tests

To run the tests run
```
$ gradle test
```

## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - language
* [Gradle](https://gradle.org//) - build tool
* [JUnit 4](https://junit.org/junit4/) - testing
* [CircleCI](https://circleci.com/) - continuous integration


