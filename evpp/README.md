# evpp: A modern C++ network library for developing high performance network services in TCP/UDP/HTTP protocols.


Test of [evpp](https://github.com/Qihoo360/evpp) web framework

## Build

```sh
git clone https://github.com/Qihoo360/evpp.git
cd evpp
git submodule update --init --recursive
sudo apt-get install libevent-dev
mkdir build
cd build
cmake ..
make -j 4
```

# Start

```sh
./bin/bin/example_httpecho
```

## Bench

```sh
$ wrk -t12 -c400 -d30s http://localhost:9009
```
