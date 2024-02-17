package com.tobeto.rentacar.config.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheManager {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisCacheManager(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Object getCachedData(String cacheName, String key) {
        try {
            return redisTemplate.opsForHash().get(cacheName, key);
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public void cacheData(String cacheName, String key, Object data) {
        try {
            redisTemplate.opsForHash().put(cacheName, key, data);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

