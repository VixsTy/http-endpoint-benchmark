# Bench simple hello-world HTTP endpoint

Just a dummy test of many languages with their simple hello world http.
Targetting µServices, so i add some common framework to tha basic languages.

## resume

| Tech              | req/s wrk | req/s fortio | cpu      | ram      |
| ----------------- | ---------:| ------------:| --------:| --------:|
| node with express | 10790     | 11533        | 1/8 vcpu | 75,5 Mo  |
| vertx-web         | 2989      | 2820         | 4/8 vcpu | 141,5 Mo |
| golang with goji  | 41360     | 47019        | 3/8 vcpu | 13,9 Mo  |
| ruby on rails     | 1325      | NA           | 1/8 vcpu | 58,4 Mo  |
| node with cluster | 32046     | 28232        | 8/8 vcpu | 508  Mo  |

## node with express

CPU : 1/8 vcpu
RAM : 75,5 Mo

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


## vertx and vertx-web

CPU : NA process take 1 virtual cpu but global usage hit the 4 physical cpu
RAM : 141,5 Mo

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

## golang with goji

CPU : 3/8 vcpu
RAM : 13,9 Mo

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


## Ruby On Rails

CPU : 1/8 vcpu
RAM : 58,4 Mo

### wrk

```
$ wrk -t12 -c400 -d30s http://localhost:3000/hello             
Running 30s test @ http://localhost:3000/hello
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.76ms  635.58us  33.59ms   88.76%
    Req/Sec   667.49    137.55   848.00     56.17%
  39883 requests in 30.09s, 10.61MB read
  Socket errors: connect 0, read 376, write 0, timeout 0
Requests/sec:   1325.58
Transfer/sec:    361.18KB
```

### fortio
Fortio error at launch.

## NodeJS with cluster module

CPU : 8/8 vcpu
RAM : 8 x 60 Mo + 1 x 28 Mo (508 Mo)

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
