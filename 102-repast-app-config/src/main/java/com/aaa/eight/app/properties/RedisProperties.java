package com.aaa.eight.app.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Project 102-repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/18 19:50
 **/
@Component
@PropertySource("classpath:config/redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisProperties {

    private String nodes;
    private String maxAttempts;
    private String commandTimeout;

}
