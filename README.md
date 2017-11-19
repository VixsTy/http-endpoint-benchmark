# Bench simple hello-world HTTP endpoint

Just a dummy test of many languages with their simple hello world http.
Targetting µServices, so i add some common framework to tha basic languages.

Those test were run on a late 2013 Macbook Pro. It's not representative and not the better way to make load testing.
I just wanted to see the differences of technologies and not the maximal capacities of them

```
Nom du modèle :	MacBook Pro
Identifiant du modèle :	MacBookPro11,3
Nom du processeur :	Intel Core i7
Vitesse du processeur :	2,3 GHz
Nombre de processeurs :	1
Nombre total de cœurs :	4
Cache de niveau 2 (par cœur) :	256 Ko
Cache de niveau 3 :	6 Mo
Mémoire :	16 Go
```

## resume

All tests were launched under similar conditions

| Tech              | version          | req/s wrk | req/s fortio | cpu      | ram      |
| ----------------- | ----------------:| ---------:| ------------:| --------:| --------:|
| node with express | v8.2.1 / 4.15.4 | 10790     | 11533        | 1/8 vcpu | 75,5 MB   |
| vertx-web         | 3.4.2           | 2989      | 2820         | 1/8 vcpu | 141,5 MB  |
| vertx-web         | 3.5.0.Beta1     | 62146     | 66839        | 1/8 vcpu | 105,4 MB  |
| golang with goji  | 1.8.3           | 41360     | 47019        | 8/8 vcpu | 13,9 MB   |
| ruby on rails     | 2.4.1 / 5.1.3   | 1325      | NA           | 1/8 vcpu | 58,4 MB   |
| node with cluster | v8.2.1 / 4.15.4 | 32046     | 28232        | 8/8 vcpu | 508 MB    |
| rust (iron.io)    | 1.5.0           | 52052     | 50562        | 8/8 vcpu | 5,6 MB    |
| spring boot       | 1.5.6           | 14860     | NA           | 8/8 vcpu | 1,40 GB   |

## Other hardware

```
CPU: Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz
RAM: 32 GB
DD: SSD Samsung 850 Evo Pro (BTRFS+Luks)
OS: Archlinux - Linux zigurath 4.12.8-2-ARCH #1 SMP PREEMPT Fri Aug 18 14:08:02 UTC 2017 x86_64 GNU/Linux
```

| Tech              | version          | req/s wrk | req/s fortio | cpu      | ram      |
| ----------------- | ----------------:| ---------:| ------------:| --------:| --------:|
| node with express | v8.2.1 / 4.15.4 | 15619     | -            | 1/8 vcpu | 78,4MB    |
| vertx-web         | 3.4.2           | -         | -            | 1/8 vcpu | -         |
| vertx-web         | 3.5.0.Beta1     | 125514    | -            | 1/8 vcpu | 232 MB    |
| golang with goji  | 1.9.0 / master  | 228509    | -            | 8/8 vcpu | 23,0 MB   |
| golang with iris  | 1.9.0 / 8.4.0   | 253615    | -            | 8/8 vcpu | 27,7 MB   |
| ruby on rails     | 2.4.1 / 5.1.3   | NA        | -            | 1/8 vcpu | -         |
| node with cluster | v8.2.1 / 4.15.4 | 60426     | -            | 8/8 vcpu | 613 MB    |
| rust (iron.io)    | 1.5.0 / 0.5.1   | 294476    | -            | 8/8 vcpu | 118 MB    |
| spring boot       | 1.5.6           | 22081     | -            | 8/8 vcpu | 881 MB    |
| python3 flask     | 3.6.2 / 0.12.2  | 2020      | -            | 1/8 vcpu | 27,4 MB   |
| nodeuv-http       |                 | 64357     | -            | 1/8 vpcu | 4.1 Mb    |

## Other hardware

```
CPU: Intel(R) Core(TM) i7-6820HQ CPU @ 2.70GHz
RAM: 8 GB
DD: SSD Samsung 850 Evo 500G
OS: Linux 4.10.0-35-generic #39-Ubuntu SMP Wed Sep 13 07:46:59 UTC 2017 x86_64 x86_64 x86_64 GNU/Linux
```

| Tech              | version          | req/s wrk | req/s fortio | cpu      | ram      |
| ----------------- | ----------------:| ---------:| ------------:| --------:| --------:|
| node with express | v8.2.1 / 4.15.4 | -          | -            | 1/8 vcpu | -        |
| vertx-web         | 3.4.2           | -          | -            | 1/8 vcpu | -        |
| vertx-web         | 3.5.0.Beta1     | -          | -            | 1/8 vcpu | -        |
| golang with goji  | 1.9.0 / master  | 85433      | -            | 8/8 vcpu | -        |
| golang with iris  | 1.9.0 / 8.4.0   | -          | -            | 8/8 vcpu | -        |
| ruby on rails     | 2.4.1 / 5.1.3   | -          | -            | 1/8 vcpu | -        |
| node with cluster | v8.2.1 / 4.15.4 | -          | -            | 8/8 vcpu | -        |
| rust (iron.io)    | 1.5.0 / 0.5.1   | 92328      | -            | 8/8 vcpu | 118 MB   |
| spring boot       | 1.5.6           | -          | -            | 8/8 vcpu | -        |
| python3 flask     | 2.7.13 / 0.12.2 | -          | -            | 1/8 vcpu | -        |
| python3 falcon    | 2.7.13 / 1.3.0  | 913        | -            | 1/8 vcpu | 63.4 MB  |
| python3 pyramid   | 2.7.13 / 1.9.1  | 830        | -            | 1/8 vcpu | 51,9 MB  |
