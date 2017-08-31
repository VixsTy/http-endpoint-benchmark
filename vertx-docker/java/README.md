# Vertx-web Hello World HTTP Server

Using [Vertx-web](http://vertx.io/docs/vertx-web/java/) web framework with JavaScript verticle : http://vertx.io/docs/vertx-docker/#_deploying_a_java_verticle_in_a_docker_container

## Build

  1. Prerequisite
    * [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
    * [Maven](https://maven.apache.org/)

  2. Build a release binary

```sh
$ mvn clean install
```
  3. Build the docker image

```sh
$ docker build -t sample/vertx-java .
```

## Start

```sh
$ docker run -t -i --net host sample/vertx-java
```

## Bench

> CPU : 1 vcpu
> RAM : 105,4 MB

### wrk
```
$ wrk -t12 -c400 -d30s http://localhost:8080         
Running 30s test @ http://localhost:8080
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.18ms    2.19ms 162.11ms   90.10%
    Req/Sec     5.21k     0.85k    8.15k    88.14%
  1865539 requests in 30.02s, 90.73MB read
  Socket errors: connect 0, read 321, write 0, timeout 0
Requests/sec:  62146.51
Transfer/sec:      3.02MB
```
