[![Build Status](https://travis-ci.org/rvep/dev_backend.svg?branch=master)](https://travis-ci.org/rvep/dev_backend)

# rvep | dev_backend

rolling vote event planner | app server

built using java, spring-boot, sql

used for webclient [dev_frontend](https://github.com/rvep/dev_frontend)

## pre-install

1. install jdk8
    - set `JAVA_HOME` environment variable
1. install mariadb
1. (optional) install latest gradle
    - otherwise just use `$ ./gradlew`
    
## install

`$ git clone git@github.com:rvep/dev_backend`

## build & run

* setup sql db
    - `$ cd data/db/scripts`
    - `$ mysql -u root -p < add-user.sql`
    - `$ mysql -u root -p < create-db.sql`
    - `$ mysql -u root -p < init-db-tables.sql`
* `$ gradle clean assemble check bootRun`
* once the server is up and running, you can test with curl
    * `$ curl -w '\n' localhost:8080/api/test/get/roles`

## contribute

if you have any input, or contributions, please share!

## donations
[donate](https://www.paypal.me/BorysNiewiadomski) a cup of coffee

## license
[MIT](/LICENSE)
