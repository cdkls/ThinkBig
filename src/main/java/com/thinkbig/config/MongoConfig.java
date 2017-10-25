package com.thinkbig.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {

	@Value("${think.big.db.mongo.host}")
	private String mongoHost;

	@Value("${think.big.db.mongo.port}")
	private int port;

	@Value("${think.big.db.mongo.dbname}")
	private String mongoDbName;

	@Value("${think.big.db.mongo.username}")
	private String mongoUsername;

	@Value("${think.big.db.mongo.password}")
	private String mongoPassword;
	

    @Bean
    public MongoClient thinkBigMongo() throws UnknownHostException {
        List<ServerAddress> seeds = new ArrayList<ServerAddress>();
        seeds.add(new ServerAddress(mongoHost, port));

        if(Strings.isNullOrEmpty(mongoUsername)) {
            return new MongoClient(seeds,
                    MongoClientOptions.builder().connectionsPerHost(50).build());
        }

        MongoCredential credential = MongoCredential.createCredential(
                mongoUsername, mongoDbName, mongoPassword.toCharArray());
        return new MongoClient(seeds, Lists.newArrayList(credential),
                MongoClientOptions.builder().connectionsPerHost(50).build());
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(thinkBigMongo(), mongoDbName);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MappingMongoConverter mongoConverter = mongoConverter();
        mongoConverter.afterPropertiesSet();
        return new MongoTemplate(mongoDbFactory(),mongoConverter);
    }

    @Bean
    public MappingMongoConverter mongoConverter() throws UnknownHostException {
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        return new MappingMongoConverter(dbRefResolver, mappingContext);
    }

}