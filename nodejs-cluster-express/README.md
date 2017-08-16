# Clustered Express Hello World HTTP Server

Using [expressjs.com](http://expressjs.com/fr/starter/hello-world.html) web framework.

## Build

  1. Install NodeJS with node version manager on [github/moovweb/gvm](https://github.com/creationix/nvm#installation)

```sh
$ curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.2/install.sh | bash
$ nvm install v8.2.1
$ npm install -g yarn
```

  2. Download dependency

```sh
$ yarn install
```

## Start

```sh
$ node app.js
```

## Bench

## NodeJS with cluster module

CPU : 8/8 vcpu
RAM : 8 x 60 MB + 1 x 28 Mo (508 MB)

note : the best rendering take with 3/8 vcpu (1 master and 2 fork), arround 27k req/s.

### wrk

```
$ wrk -t12 -c400 -d30s http://127.0.0.1:3000
Running 30s test @ http://127.0.0.1:3000
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    12.30ms    7.77ms 323.57ms   94.14%
    Req/Sec     2.69k   401.47     4.30k    78.03%
  962447 requests in 30.03s, 198.26MB read
  Socket errors: connect 0, read 285, write 0, timeout 0
Requests/sec:  32046.67
Transfer/sec:      6.60MB
```

### fortio

```
$ ./fortio load -c 12 -t 30s -qps 0 http://127.0.0.1:3000
Fortio running at 0 queries per second, 8->8 procs, for 30s: http://127.0.0.1:3000
17:31:55 I httprunner.go:75> Starting http test for http://127.0.0.1:3000 with 12 threads at 0.0 qps
Starting at max qps with 12 thread(s) [gomax 8] for 30s
17:32:25 I periodic.go:253> T011 ended after 30.000008173s : 54700 calls. qps=1823.3328365966909
17:32:25 I periodic.go:253> T005 ended after 30.000075645s : 102047 calls. qps=3401.558089637944
17:32:25 I periodic.go:253> T007 ended after 30.00013593s : 102656 calls. qps=3421.8511622590504
17:32:25 I periodic.go:253> T003 ended after 30.000164859s : 55049 calls. qps=1834.9565830297558
17:32:25 I periodic.go:253> T006 ended after 30.000184287s : 102076 calls. qps=3402.5124320397144
17:32:25 I periodic.go:253> T010 ended after 30.000194523s : 55066 calls. qps=1835.5214316288184
17:32:25 I periodic.go:253> T001 ended after 30.000392743s : 53942 calls. qps=1798.04312770493
17:32:25 I periodic.go:253> T002 ended after 30.00042705s : 54922 calls. qps=1830.7072732152992
17:32:25 I periodic.go:253> T000 ended after 30.000489269s : 54945 calls. qps=1831.470130614689
17:32:25 I periodic.go:253> T004 ended after 30.000497102s : 102449 calls. qps=3414.9100813789573
17:32:25 I periodic.go:253> T009 ended after 30.000620301s : 53854 calls. qps=1795.09621666739
17:32:25 I periodic.go:253> T008 ended after 30.000697963s : 55301 calls. qps=1843.3237809401294
Ended after 30.000731983s : 847007 calls. qps=28233
Aggregated Function Time : count 847007 avg 0.00042486983 +/- 0.0004311 min 9.8041e-05 max 0.042645172 sum 359.867724
# range, mid point, percentile, count
< 0.001 , 0.001 , 95.62, 809943
>= 0.001 < 0.002 , 0.0015 , 98.98, 28387
>= 0.002 < 0.003 , 0.0025 , 99.60, 5280
>= 0.003 < 0.004 , 0.0035 , 99.80, 1710
>= 0.004 < 0.005 , 0.0045 , 99.89, 723
>= 0.005 < 0.006 , 0.0055 , 99.93, 407
>= 0.006 < 0.007 , 0.0065 , 99.95, 164
>= 0.007 < 0.008 , 0.0075 , 99.97, 119
>= 0.008 < 0.009 , 0.0085 , 99.98, 86
>= 0.009 < 0.01 , 0.0095 , 99.98, 52
>= 0.01 < 0.011 , 0.0105 , 99.99, 39
>= 0.011 < 0.012 , 0.0115 , 99.99, 25
>= 0.012 < 0.014 , 0.013 , 99.99, 29
>= 0.014 < 0.016 , 0.015 , 100.00, 15
>= 0.016 < 0.018 , 0.017 , 100.00, 7
>= 0.018 < 0.02 , 0.019 , 100.00, 5
>= 0.02 < 0.025 , 0.0225 , 100.00, 11
>= 0.025 < 0.03 , 0.0275 , 100.00, 1
>= 0.03 < 0.035 , 0.0325 , 100.00, 2
>= 0.035 < 0.04 , 0.0375 , 100.00, 1
>= 0.04 < 0.045 , 0.0425 , 100.00, 1
# target 50% 0.000569658
# target 75% 0.000805466
# target 99% 0.00203919
# target 99.9% 0.00528745
Code 200 : 847007
Response Header Sizes : count 847007 avg 204 +/- 0 min 204 max 204 sum 172789428
Response Body/Total Sizes : count 847007 avg 216 +/- 0 min 216 max 216 sum 182953512
All done 847007 calls (plus 12 warmup) 0.425 ms avg, 28232.9 qps
```
