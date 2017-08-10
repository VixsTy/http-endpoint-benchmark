# Bench basic hello-world


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
