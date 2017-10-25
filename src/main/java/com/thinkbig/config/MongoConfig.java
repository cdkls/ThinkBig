package com.thinkbig.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@SuppressWarnings("deprecation")
@Profile("!test")
@Configuration
public class MongoConfig {

	private static final int MONGO_CONNECTION_PER_HOST = 50;

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
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		UserCredentials userCredentials = new UserCredentials(mongoUsername,
				mongoPassword);
		return new SimpleMongoDbFactory(thinkBigMongo(), mongoDbName,
				userCredentials);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		MappingMongoConverter mongoConverter = mongoConverter();
		mongoConverter.afterPropertiesSet();
		return new MongoTemplate(mongoDbFactory(), mongoConverter);
	}

	@Bean
	public MappingMongoConverter mongoConverter() throws UnknownHostException {
		MongoMappingContext mappingContext = new MongoMappingContext();
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
		return new MappingMongoConverter(dbRefResolver, mappingContext);
	}

	@Bean
	public Mongo thinkBigMongo() throws UnknownHostException {
		List<ServerAddress> seeds = new ArrayList<ServerAddress>();
		seeds.add(new ServerAddress(mongoHost, port));
		MongoOptions mongoOptions = new MongoOptions();
		mongoOptions.fsync = true;
		mongoOptions.connectionsPerHost = MONGO_CONNECTION_PER_HOST;
		mongoOptions.setWriteConcern(WriteConcern.SAFE);
		return new Mongo(seeds, mongoOptions);
	}
}