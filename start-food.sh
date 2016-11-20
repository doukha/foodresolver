#!/usr/bin/env bash


docker build -t foodresolver .

ROOT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo $ROOT_DIR

docker run -t -i \
        -p 127.0.0.1:4200:4200 \
        -p 9090:8080 \
        -v $HOME/.m2:/root/.m2 \
        -v $ROOT_DIR:/mnt/foodresolver foodresolver

#        -v /usr/local/bin/node:/usr/bin/nodejs \

        #-p 27017:27017 \
#--add-host=database:127.0.0.1 \