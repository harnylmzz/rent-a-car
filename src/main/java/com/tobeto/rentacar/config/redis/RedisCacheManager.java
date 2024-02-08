package com.tobeto.rentacar.config.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheManager {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisCacheManager(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Object getCachedData(String cacheName, String key) {
        return redisTemplate.opsForHash().get(cacheName, key);
    }

    public void cacheData(String cacheName, String key, Object data) {
        redisTemplate.opsForHash().put(cacheName, key, data);
    }

}
