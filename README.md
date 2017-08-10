# Bench simple hello-world HTTP endpoint

## node app.js

```
wrk -t12 -c400 -d30s http://localhost:3000        
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
RAM : 75,5 Mo


## vertx

```
wrk -t12 -c400 -d30s http://localhost:8080
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
RAM : 141,5 Mo

## golang

```
wrk -t12 -c400 -d30s http://localhost:8000
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
RAM : 13,9 Mo
