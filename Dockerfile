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

#Java 8
RUN apt-get -y install software-properties-common

RUN echo "ORACLE ==============="
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update &&  apt-get install -y oracle-java8-installer &&  rm -rf /var/lib/apt/lists/* &&   rm -rf /var/cache/oracle-jdk8-installer

#maven
RUN echo "MAVEN ================"
#RUN sudo apt-add-repository ppa:andrei-pozolotin/maven3 && \
 #   apt-get update && sudo apt-get -y install maven3
RUN  sudo apt-get update && sudo apt-get -y install maven
RUN echo "$(mvn -v)"


EXPOSE 4200
EXPOSE 49153
EXPOSE 8080
EXPOSE 3000
RUN mkdir /mnt/foodresolver
WORKDIR /mnt/foodresolver
COPY spring-boota.sh .
COPY npm-boota.sh .

RUN ln -s /usr/bin/nodejs /usr/bin/node

CMD ["ln -s" ,"/usr/bin/nodejs" ,"/usr/bin/node"]
ENTRYPOINT ["bash","spring-boota.sh"]
#RUN ["mvn", "spring-boot:run"]
#WORKDIR /mnt/foodresolver/src/main/recipefront
#RUN ["npm","start"]
#EXPOSE 4200

#CMD ["mvn install"]
#RUN mkdir project
#conf
#VOLUME . project
#CMD run.sh

#lancement