# Express Hello World HTTP Server

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

CPU : 1/8 vcpu
RAM : 75,5 MB

### wrk

```
$ wrk -t12 -c400 -d30s http://localhost:3000        
Running 30s test @ http://localhost:3000
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    35.07ms    4.79ms 221.08ms   87.74%
    Req/Sec     0.90k    99.02     1.28k    88.78%
  324599 requests in 30.08s, 66.87MB read
  Socket errors: connect 0, read 259, write 0, timeout 0
Requests/sec:  10790.20
Transfer/sec:      2.22MB
```

### fortio

```
$ ./fortio load -c 12 -t 30s -qps 0 http://127.0.0.1:3000
Fortio running at 0 queries per second, 8->8 procs, for 30s: http://127.0.0.1:3000
18:14:15 I httprunner.go:75> Starting http test for http://127.0.0.1:3000 with 12 threads at 0.0 qps
Starting at max qps with 12 thread(s) [gomax 8] for 30s
18:14:45 I periodic.go:253> T006 ended after 30.000072272s : 28839 calls. qps=961.2976841697923
18:14:45 I periodic.go:253> T011 ended after 30.000157271s : 28825 calls. qps=960.8282963191003
18:14:45 I periodic.go:253> T009 ended after 30.000243713s : 28828 calls. qps=960.925526998568
18:14:45 I periodic.go:253> T004 ended after 30.000344403s : 28822 calls. qps=960.7223041452095
18:14:45 I periodic.go:253> T010 ended after 30.000435264s : 28828 calls. qps=960.9193915460653
18:14:45 I periodic.go:253> T005 ended after 30.000536881s : 28833 calls. qps=961.0828004301675
18:14:45 I periodic.go:253> T000 ended after 30.000657437s : 28842 calls. qps=961.3789317973071
18:14:45 I periodic.go:253> T001 ended after 30.00073878s : 28842 calls. qps=961.376325146617
18:14:45 I periodic.go:253> T003 ended after 30.000839323s : 28842 calls. qps=961.3731032480954
18:14:45 I periodic.go:253> T002 ended after 30.000915982s : 28842 calls. qps=961.3706467264091
18:14:45 I periodic.go:253> T007 ended after 30.000996763s : 28842 calls. qps=961.3680581296758
18:14:45 I periodic.go:253> T008 ended after 30.001075195s : 28827 calls. qps=960.8655627383757
Ended after 30.001089264s : 346012 calls. qps=11533
Aggregated Function Time : count 346012 avg 0.0010403853 +/- 0.0001349 min 0.000227997 max 0.003695345 sum 359.985784
# range, mid point, percentile, count
< 0.001 , 0.001 , 49.10, 169893
>= 0.001 < 0.002 , 0.0015 , 99.76, 175299
>= 0.002 < 0.003 , 0.0025 , 99.99, 782
>= 0.003 < 0.004 , 0.0035 , 100.00, 38
# target 50% 0.00101776
# target 75% 0.00151122
# target 99% 0.00198494
# target 99.9% 0.00260612
Code 200 : 346012
Response Header Sizes : count 346012 avg 204 +/- 0 min 204 max 204 sum 70586448
Response Body/Total Sizes : count 346012 avg 216 +/- 0 min 216 max 216 sum 74738592
All done 346012 calls (plus 12 warmup) 1.040 ms avg, 11533.3 qps
```
