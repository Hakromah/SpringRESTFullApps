package com.telusko.config;

import com.telusko.model.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {
    // We need these two configurations in order to connect to the Redis Cash memory
    // JedisConnectionFactory
    @Bean
    public JedisConnectionFactory jedisConnect() {
        JedisConnectionFactory jedisConnection = new JedisConnectionFactory();
        // redis server config
        //jedisConnection.setPort(45454);
        return jedisConnection;
    }

    //RedisTemplate
    @Bean
    public RedisTemplate<String, Country> redisTemplate() {

        RedisTemplate<String, Country> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnect());
        return redisTemplate;   
    }
}
