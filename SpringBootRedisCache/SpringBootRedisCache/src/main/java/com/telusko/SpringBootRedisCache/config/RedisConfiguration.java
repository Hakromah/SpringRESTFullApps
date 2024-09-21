package com.telusko.SpringBootRedisCache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.telusko.SpringBootRedisCache.model.Country;

@Configuration
public class RedisConfiguration
{
	
	//jedisconnectionfactory
	
	@Bean
	public JedisConnectionFactory jedisConnect()
	{
		JedisConnectionFactory jedisConnection = new JedisConnectionFactory();
		//redis server config
		//jedisConnection.setPort(45454);
		return jedisConnection;
	}
	
	
	//redistemplate
	@Bean
	public RedisTemplate<String, Country> redisTemplate()
	{
		RedisTemplate<String, Country> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnect());
		return redisTemplate;
	}

}
