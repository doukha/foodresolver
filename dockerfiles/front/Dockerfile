FROM ubuntu
MAINTAINER doukha <sami.boukhris.fr@gmail.com>

#installation des api
RUN apt-get update -yq && apt-get upgrade -yq && \
    apt-get install -yq curl git nano

RUN apt-get install sudo
RUN curl -sL https://deb.nodesource.com/setup | sudo bash - &&  apt-get install -yq nodejs build-essential


RUN echo "installing NPM ...."
#npm
RUN apt-get -y install npm

RUN echo "NPM Version : "
RUN echo "$(npm -v)"
RUN echo "npm installed =============="

EXPOSE 4200
EXPOSE 49153
RUN mkdir /mnt/foodresolver
WORKDIR /mnt/foodresolver
RUN echo "before ln"
RUN ln -s /usr/bin/nodejs /usr/bin/node
RUN echo "after ln"
