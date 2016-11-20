package com.paris.config;

import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.jongo.Jongo;
import org.jongo.marshall.jackson.JacksonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
public class JongoConfig {

   private static final Logger LOGGER = LoggerFactory.getLogger(JongoConfig.class);

   @Bean
   public Jongo jongo(@Value("${database.document.name}") String dbName, //
                      MongoClient mongoClient) throws UnknownHostException {
      return new Jongo(mongoClient.getDB(dbName), new JacksonMapper.Builder() //
            .registerModule(new JSR310Module()) //
            .build());
   }

   @Bean
   public MongoClient mongoClient(ServerAddress serverAddress, @Value("${database.document.name}") String dbName, //
                                  @Value("${database.document.username}") String username, //
                                  @Value("${database.document.password}") String password) {

      List<MongoCredential> credentials = Optional.ofNullable(username) //
            .filter(login -> !login.isEmpty()) //
            .map(login -> Collections.singletonList(MongoCredential.createMongoCRCredential(username, //
                  dbName, password.toCharArray())) //
            ).orElseGet(Collections::<MongoCredential>emptyList);
      return new MongoClient(serverAddress, credentials);
   }

   @Bean
   public ServerAddress serverAddress(@Value("${database.document.host}") String host, //
                                      @Value("${database.document.port}") int port) {
      try {
         return new ServerAddress(host, port);
      } catch (Exception e) {
         LOGGER.error("Unable to connect to document database at '{}'", host, e);
         throw new IllegalStateException("Unable to connect to database", e);
      }

   }
}
