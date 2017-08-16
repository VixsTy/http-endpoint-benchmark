# Rails Hello World HTTP Server

Using [RubyOnRails](http://rubyonrails.org/) web framework.

## Build

  1. Install Ruby via [rvm](https://rvm.io/)

```sh
$ curl -sSL https://get.rvm.io | bash -s stable
$ gem install rails
$ gem install bundle
```

  2. Build a release binary

```sh
$ bundle install
```

## Start

```sh
$ rails server -e production
```

## Bench

CPU : 1/8 vcpu
RAM : 58,4 MB

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
