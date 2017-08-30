# Vertx-web Hello World HTTP Server

Using [Vertx-web](http://vertx.io/docs/vertx-web/java/) web framework.

## Build

  1. Prerequisite
    * [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
    * [Maven](https://maven.apache.org/)

  2. Build a release binary

```sh
$ mvn clean install
```

## Start

```sh
$ java -jar target/maven-simplest-3.5.0.Beta1-fat.jar
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

### fortio

```
$ ./fortio load -c 12 -t 30s -qps 0 http://127.0.0.1:8080         
Fortio running at 0 queries per second, 8->8 procs, for 30s: http://127.0.0.1:8080
17:15:34 I httprunner.go:75> Starting http test for http://127.0.0.1:8080 with 12 threads at 0.0 qps
Starting at max qps with 12 thread(s) [gomax 8] for 30s
17:16:04 I periodic.go:253> T004 ended after 30.000010869s : 167277 calls. qps=5575.897979852161
17:16:04 I periodic.go:253> T010 ended after 30.00006772s : 167018 calls. qps=5567.254099518413
17:16:04 I periodic.go:253> T005 ended after 30.000078544s : 167244 calls. qps=5574.785404468506
17:16:04 I periodic.go:253> T008 ended after 30.000075639s : 167219 calls. qps=5573.952613059943
17:16:04 I periodic.go:253> T006 ended after 30.00008205s : 166990 calls. qps=5566.318109453304
17:16:04 I periodic.go:253> T007 ended after 30.000106901s : 166636 calls. qps=5554.5135405649335
17:16:04 I periodic.go:253> T000 ended after 30.000083275s : 167340 calls. qps=5577.984516444646
17:16:04 I periodic.go:253> T001 ended after 30.000094485s : 167223 calls. qps=5574.082444427341
17:16:04 I periodic.go:253> T009 ended after 30.000116477s : 167285 calls. qps=5576.145016911896
17:16:04 I periodic.go:253> T011 ended after 30.000121298s : 167372 calls. qps=5579.044109103588
17:16:04 I periodic.go:253> T002 ended after 30.000128394s : 166626 calls. qps=5554.176229236574
17:16:04 I periodic.go:253> T003 ended after 30.000173081s : 166981 calls. qps=5566.001221031423
Ended after 30.000192404s : 2005211 calls. qps=66840
Aggregated Function Time : count 2005211 avg 0.00017948018 +/- 8.893e-05 min 4.0261e-05 max 0.011964501 sum 359.895634
# range, mid point, percentile, count
< 0.001 , 0.001 , 99.88, 2002830
>= 0.001 < 0.002 , 0.0015 , 99.97, 1734
>= 0.002 < 0.003 , 0.0025 , 99.99, 395
>= 0.003 < 0.004 , 0.0035 , 100.00, 173
>= 0.004 < 0.005 , 0.0045 , 100.00, 59
>= 0.005 < 0.006 , 0.0055 , 100.00, 6
>= 0.006 < 0.007 , 0.0065 , 100.00, 2
>= 0.011 < 0.012 , 0.0115 , 100.00, 12
# target 50% 0.000520701
# target 75% 0.000760921
# target 99% 0.000991532
# target 99.9% 0.00121672
Code 200 : 2005211
Response Header Sizes : count 2005211 avg 39 +/- 0 min 39 max 39 sum 78203229
Response Body/Total Sizes : count 2005211 avg 51 +/- 6.896e-07 min 51 max 51 sum 102265761
All done 2005211 calls (plus 12 warmup) 0.179 ms avg, 66839.9 qps
```
