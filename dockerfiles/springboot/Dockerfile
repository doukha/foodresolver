FROM ubuntu
MAINTAINER doukha <sami.boukhris.fr@gmail.com>

#installation des api
RUN apt-get update -yq && apt-get upgrade -yq && \
    apt-get install -yq curl git nano

RUN apt-get install sudo
RUN curl -sL https://deb.nodesource.com/setup | sudo bash - &&  apt-get install -yq nodejs build-essential

#Java 8
RUN apt-get -y install software-properties-common

RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update &&  apt-get install -y oracle-java8-installer &&  rm -rf /var/lib/apt/lists/* &&   rm -rf /var/cache/oracle-jdk8-installer

#maven
RUN  sudo apt-get update && sudo apt-get -y install maven

RUN mkdir /mnt/foodresolver
WORKDIR /mnt/foodresolver

RUN ln -s /usr/bin/nodejs /usr/bin/node