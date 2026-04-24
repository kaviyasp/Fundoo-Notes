package com.fundoonotes.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String value, long ttlSeconds) {

        System.out.println("👉 Writing to Redis: " + key);

        redisTemplate.opsForValue().set(key, value, ttlSeconds, TimeUnit.SECONDS);

        System.out.println("✅ Written to Redis");
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}