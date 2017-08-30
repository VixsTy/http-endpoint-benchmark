# Spring boot Hello World HTTP Server

Using [spring-boot](https://github.com/spring-projects/spring-boot) web framework.

## Build

  1. Prerequisite
    * [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
    * [Gradle](https://gradle.org/)

  2. Build a release binary

```sh
$ ./gradlew build
```

## Start

```sh
$ java -jar build/libs/gs-rest-service-0.1.0.jar
```

## Bench

> CPU : 8/8 vcpu
> RAM : 1,40 GB

### wrk
```
$ wrk -t12 -c400 -d30s http://localhost:8080/greeting
Running 30s test @ http://localhost:8080/greeting
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    30.58ms   32.07ms 550.32ms   91.62%
    Req/Sec     1.26k   483.28     3.91k    62.83%
  447085 requests in 30.09s, 75.87MB read
  Socket errors: connect 0, read 294, write 0, timeout 0
Requests/sec:  14860.47
Transfer/sec:      2.52MB
```

### fortio

NA
