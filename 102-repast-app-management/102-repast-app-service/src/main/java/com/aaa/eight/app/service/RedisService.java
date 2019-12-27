package com.aaa.eight.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/23 21:42
 **/
@Service
public class RedisService {
    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 根据key取数据
     * @param key
     * @return
     */
    public String get(String key) {
        return jedisCluster.get(key);
    }

    /**
     * 向redis中保存数据
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    /**
     * 根据key删除缓存中的数据
     * @param key
     * @return
     */
    public Long del(String key) {
        return jedisCluster.del(key);
    }

    /**
     * 设置key失效时间
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, Integer seconds) {
        return jedisCluster.expire(key, seconds);
    }

}
