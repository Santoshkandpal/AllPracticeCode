package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ashokit.model.User;

@Configuration
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf= new JedisConnectionFactory();
		// jcf.SetHostname(hostname);
		// jcf.setPassword(password);
		// jcf.setPort(port);'
		
		return jcf;
	}
	
	@Bean
	RedisTemplate<String, User> redisTemplate(){
		
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
		
		
	}

}
