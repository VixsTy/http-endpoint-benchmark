# Goji Hello World HTTP Server

Using [goji.io](https://goji.io/) web framework.

## Build

  1. Install Go
    * by following instructions on [golang.org](https://golang.org/dl/)
    * with go version manager on [github/moovweb/gvm](https://github.com/moovweb/gvm#installing)

```sh
$ bash < <(curl -s -S -L https://raw.githubusercontent.com/moovweb/gvm/master/binscripts/gvm-installer)
$ gvm install go1.9.2 -B
$ gvm use go1.9.2
$ go get goji.io
```

  2. Build a release binary

```sh
$ go build hello.go
```
  3. Build the docker image

```sh
$ docker build -t golang/hello .
```

## Start

With docker

```sh
$ docker run -ti --net host golang/hello
```

Without docker
```sh
$ ./hello
```

## Bench

> CPU : 8/8 vcpu
> RAM : 13,9 MB

### wrk

```
$ wrk -t12 -c400 -d30s http://localhost:8000
Running 30s test @ http://localhost:8000
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     9.32ms    1.79ms  25.92ms   70.31%
    Req/Sec     3.47k   447.10     5.86k    74.03%
  1241946 requests in 30.03s, 153.97MB read
  Socket errors: connect 0, read 252, write 0, timeout 0
Requests/sec:  41360.20
Transfer/sec:      5.13MB
```

### fortio

```
$ ./fortio load -c 12 -t 30s -qps 0 http://127.0.0.1:8000
Fortio running at 0 queries per second, 8->8 procs, for 30s: http://127.0.0.1:8000
18:15:07 I httprunner.go:75> Starting http test for http://127.0.0.1:8000 with 12 threads at 0.0 qps
Starting at max qps with 12 thread(s) [gomax 8] for 30s
18:15:37 I periodic.go:253> T001 ended after 30.00003506s : 117547 calls. qps=3918.228754229996
18:15:37 I periodic.go:253> T006 ended after 30.00012406s : 117506 calls. qps=3916.8504691843596
18:15:37 I periodic.go:253> T007 ended after 30.00012306s : 117577 calls. qps=3919.217256704146
18:15:37 I periodic.go:253> T002 ended after 30.00013606s : 117529 calls. qps=3917.6155656408714
18:15:37 I periodic.go:253> T004 ended after 30.00013006s : 117588 calls. qps=3919.5830073011357
18:15:37 I periodic.go:253> T003 ended after 30.00015906s : 117576 calls. qps=3919.1792205117727
18:15:37 I periodic.go:253> T000 ended after 30.00014406s : 117547 calls. qps=3918.2145180672173
18:15:37 I periodic.go:253> T009 ended after 30.00015506s : 117596 calls. qps=3919.846406287208
18:15:37 I periodic.go:253> T011 ended after 30.00017106s : 117547 calls. qps=3918.2109916942586
18:15:37 I periodic.go:253> T005 ended after 30.00012906s : 117561 calls. qps=3918.683141825124
18:15:37 I periodic.go:253> T008 ended after 30.00016506s : 117496 calls. qps=3916.511784685494
18:15:37 I periodic.go:253> T010 ended after 30.00012706s : 117524 calls. qps=3917.4500749597823
Ended after 30.00021506s : 1410594 calls. qps=47019
Aggregated Function Time : count 1410594 avg 0.00025509174 +/- 5.252e-05 min 5.9734e-05 max 0.003667916 sum 359.830881
# range, mid point, percentile, count
< 0.001 , 0.001 , 99.99, 1410398
>= 0.001 < 0.002 , 0.0015 , 100.00, 159
>= 0.002 < 0.003 , 0.0025 , 100.00, 13
>= 0.003 < 0.004 , 0.0035 , 100.00, 24
# target 50% 0.000529932
# target 75% 0.000765032
# target 99% 0.000990727
# target 99.9% 0.00099919
Code 200 : 1410594
Response Header Sizes : count 1410594 avg 117 +/- 0 min 117 max 117 sum 165039498
Response Body/Total Sizes : count 1410594 avg 130 +/- 0 min 130 max 130 sum 183377220
All done 1410594 calls (plus 12 warmup) 0.255 ms avg, 47019.5 qps
```
