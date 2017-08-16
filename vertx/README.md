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
$ java -jar target/maven-simplest-3.4.2-fat.jar
```

## Bench

> CPU : NA process take 1 virtual cpu but global usage hit the 4 physical cpu
> RAM : 141,5 MB

### wrk
```
$ wrk -t12 -c400 -d30s http://localhost:8080
Running 30s test @ http://localhost:8080
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   129.80ms   12.39ms 155.59ms   90.03%
    Req/Sec   250.38     39.46   480.00     67.94%
  89890 requests in 30.07s, 4.37MB read
  Socket errors: connect 0, read 262, write 0, timeout 0
Requests/sec:   2989.15
Transfer/sec:    148.87KB
```

### fortio

```
$ ./fortio load -c 12 -t 30s -qps 0 http://127.0.0.1:8080
Fortio running at 0 queries per second, 8->8 procs, for 30s: http://127.0.0.1:8080
19:01:41 I httprunner.go:75> Starting http test for http://127.0.0.1:8080 with 12 threads at 0.0 qps
Starting at max qps with 12 thread(s) [gomax 8] for 30s
19:02:11 I periodic.go:253> T005 ended after 30.000213945s : 7052 calls. qps=235.06499030068835
19:02:11 I periodic.go:253> T000 ended after 30.000364697s : 7051 calls. qps=235.0304761696811
19:02:11 I periodic.go:253> T002 ended after 30.000543646s : 7051 calls. qps=235.02907424613008
19:02:11 I periodic.go:253> T010 ended after 30.00100924s : 7051 calls. qps=235.02542676460976
19:02:11 I periodic.go:253> T009 ended after 30.001039526s : 7051 calls. qps=235.02518950682844
19:02:11 I periodic.go:253> T003 ended after 30.001413157s : 7052 calls. qps=235.05559431805
19:02:11 I periodic.go:253> T007 ended after 30.001446286s : 7052 calls. qps=235.05533475867043
19:02:11 I periodic.go:253> T004 ended after 30.001787167s : 7054 calls. qps=235.119326749939
19:02:11 I periodic.go:253> T006 ended after 30.001847893s : 7052 calls. qps=235.05218829022078
19:02:11 I periodic.go:253> T001 ended after 30.002214425s : 7053 calls. qps=235.08264757027183
19:02:11 I periodic.go:253> T008 ended after 30.00226982s : 7054 calls. qps=235.1155443345053
19:02:11 I periodic.go:253> T011 ended after 30.002628414s : 7056 calls. qps=235.17939503951888
Ended after 30.002649249s : 84629 calls. qps=2820.7
Aggregated Function Time : count 84629 avg 0.0042538702 +/- 0.0006206 min 0.001592278 max 0.0329177 sum 360.000784
# range, mid point, percentile, count
>= 0.001 < 0.002 , 0.0015 , 0.00, 3
>= 0.002 < 0.003 , 0.0025 , 0.02, 13
>= 0.003 < 0.004 , 0.0035 , 11.03, 9319
>= 0.004 < 0.005 , 0.0045 , 96.91, 72682
>= 0.005 < 0.006 , 0.0055 , 98.94, 1715
>= 0.006 < 0.007 , 0.0065 , 99.42, 406
>= 0.007 < 0.008 , 0.0075 , 99.69, 225
>= 0.008 < 0.009 , 0.0085 , 99.80, 94
>= 0.009 < 0.01 , 0.0095 , 99.91, 92
>= 0.01 < 0.011 , 0.0105 , 99.91, 6
>= 0.011 < 0.012 , 0.0115 , 99.92, 7
>= 0.012 < 0.014 , 0.013 , 99.94, 15
>= 0.014 < 0.016 , 0.015 , 99.94, 5
>= 0.016 < 0.018 , 0.017 , 99.96, 10
>= 0.018 < 0.02 , 0.019 , 99.98, 17
>= 0.02 < 0.025 , 0.0225 , 99.98, 7
>= 0.025 < 0.03 , 0.0275 , 99.99, 5
>= 0.03 < 0.035 , 0.0325 , 100.00, 8
# target 50% 0.00445375
# target 75% 0.00474484
# target 99% 0.0061249
# target 99.9% 0.00994968
Code 200 : 84629
Response Header Sizes : count 84629 avg 39 +/- 0 min 39 max 39 sum 3300531
Response Body/Total Sizes : count 84629 avg 51 +/- 0 min 51 max 51 sum 4316079
All done 84629 calls (plus 12 warmup) 4.254 ms avg, 2820.7 qps
```
