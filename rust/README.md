# Rust Hello World HTTP Server

Using [iron.io](https://github.com/iron/iron) web framework.

## Build

  1. Install RUST via Rustup

```sh
$ curl https://sh.rustup.rs -sSf | sh
```

  2. Build a release binary

```sh
$ cargo build --release
```

## Start

```sh
$ ./target/release/hello-world
```

## Bench

CPU: 8/8 vcpu RAM: 118MB

### wrk

```
$ wrk -t12 -c400 -d30s http://localhost:3000
Running 30s test @ http://localhost:3000
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.23ms  811.12us 152.02ms   99.58%
    Req/Sec     5.25k     2.34k   27.58k    64.66%
  1566727 requests in 30.10s, 170.33MB read
  Socket errors: connect 0, read 532, write 0, timeout 0
Requests/sec:  52052.47
Transfer/sec:      5.66MB
```

### fortio

```
$ ./fortio load -c 12 -t 30s -qps 0 http://localhost:3000
Fortio running at 0 queries per second, 8->8 procs, for 30s: http://localhost:3000
18:34:43 I httprunner.go:75> Starting http test for http://localhost:3000 with 12 threads at 0.0 qps
Starting at max qps with 12 thread(s) [gomax 8] for 30s
18:35:13 I periodic.go:253> T003 ended after 30.00008337s : 126280 calls. qps=4209.321635628508
18:35:13 I periodic.go:253> T002 ended after 30.000130809s : 128179 calls. qps=4272.6147034514415
18:35:13 I periodic.go:253> T005 ended after 30.000135635s : 128290 calls. qps=4276.313999405023
18:35:13 I periodic.go:253> T010 ended after 30.000136692s : 125529 calls. qps=4184.280934742349
18:35:13 I periodic.go:253> T004 ended after 30.000145499s : 126974 calls. qps=4232.446139443972
18:35:13 I periodic.go:253> T007 ended after 30.000153269s : 127460 calls. qps=4248.644960481185
18:35:13 I periodic.go:253> T008 ended after 30.000165387s : 126842 calls. qps=4228.0433578864395
18:35:13 I periodic.go:253> T001 ended after 30.00017706s : 126616 calls. qps=4220.508423892616
18:35:13 I periodic.go:253> T011 ended after 30.000170982s : 124598 calls. qps=4153.242995673537
18:35:13 I periodic.go:253> T000 ended after 30.000187987s : 123546 calls. qps=4118.1741945595895
18:35:13 I periodic.go:253> T006 ended after 30.000197782s : 126977 calls. qps=4232.538762667281
18:35:13 I periodic.go:253> T009 ended after 30.000221616s : 125595 calls. qps=4186.469073715659
Ended after 30.000238454s : 1516886 calls. qps=50562
Aggregated Function Time : count 1516886 avg 0.00023722996 +/- 0.0008206 min 4.1869e-05 max 0.151327281 sum 359.850807
# range, mid point, percentile, count
< 0.001 , 0.001 , 99.99, 1516804
>= 0.001 < 0.002 , 0.0015 , 100.00, 34
>= 0.002 < 0.003 , 0.0025 , 100.00, 3
>= 0.14 < 0.16 , 0.15 , 100.00, 45
# target 50% 0.00052096
# target 75% 0.000760506
# target 99% 0.00099047
# target 99.9% 0.000999094
Code 200 : 1516886
Response Header Sizes : count 1516886 avg 102 +/- 0 min 102 max 102 sum 154722372
Response Body/Total Sizes : count 1516886 avg 114 +/- 0 min 114 max 114 sum 172925004
All done 1516886 calls (plus 12 warmup) 0.237 ms avg, 50562.5 qps
```
