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

| Tech              | req/s wrk | req/s fortio | cpu      | ram      |
| ----------------- | ---------:| ------------:| --------:| --------:|
| node with express | 10790     | 11533        | 1/8 vcpu | 75,5 MB  |
| vertx-web         | 2989      | 2820         | 4/8 vcpu | 141,5 MB |
| golang with goji  | 41360     | 47019        | 8/8 vcpu | 13,9 MB  |
| ruby on rails     | 1325      | NA           | 1/8 vcpu | 58,4 MB  |
| node with cluster | 32046     | 28232        | 8/8 vcpu | 508 MB  |
| rust (iron.io)    | 52052     | 50562        | 8/8 vcpu | 5,6 MB   |
| spring boot       | 14860     | NA           | 8/8 vcpu | 1,40 GB  |
