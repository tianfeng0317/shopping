package com.shopping.demo.utils;

import com.shopping.demo.base.config.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * @Author :tianfeng
 * @Date : 2020/12/2 10:16
 * @Description:
 */
@Service
public class RedisCache {

    @Autowired
    private JedisCluster jedisCluster;

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    RedisConfig redisConfig;

    @Autowired
    public RedisCache(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }

    private static final String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值

    /**
     * 设置缓存
     * @param prefix 缓存前缀（用于区分缓存，防止缓存键值重复）
     * @param key    缓存key
     * @param value  缓存value
     */
    public void set(String prefix, String key, String value) {
        jedisCluster.set(prefix + KEY_SPLIT + key, value);
        logger.debug("RedisUtil:set cache key={},value={}", prefix + KEY_SPLIT + key, value);
    }

    /**
     * 设置缓存，并且自己指定过期时间
     * @param prefix
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String prefix, String key, String value, int expireTime) {
        jedisCluster.setex(prefix + KEY_SPLIT + key, expireTime, value);
        logger.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,
                expireTime);
    }

    /**
     * 获取指定key的缓存
     * @param prefix
     * @param key
     */
    public String get(String prefix, String key) {
        String value = jedisCluster.get(prefix + KEY_SPLIT + key);
        logger.debug("RedisUtil:get cache key={},value={}", prefix + KEY_SPLIT + key, value);
        return value;
    }

    /**
     * 删除指定key的缓存
     * @param prefix
     * @param key
     */
    public void deleteWithPrefix(String prefix, String key) {
        jedisCluster.del(prefix + KEY_SPLIT + key);
        logger.debug("RedisUtil:delete cache key={}", prefix + KEY_SPLIT + key);
    }

    /**
     * 删除指定key
     * @param key
     */
    public void delete(String key) {
        jedisCluster.del(key);
        logger.debug("RedisUtil:delete cache key={}", key);
    }

    /**
     * 某key自增
     * @param key
     * @return
     */
    public long increase(String key) {
        return jedisCluster.incr(key);
    }

    /**
     * 某key自增
     * @param prefix
     * @param key
     * @return
     */
    public long increaseWithPrefix(String prefix,String key) {
        return jedisCluster.incr(prefix + KEY_SPLIT + key);
    }

    /**
     * 某key自减
     * @param key
     * @return
     */
    public long decrease(String key) {
        return jedisCluster.decr(key);
    }

    /**
     * 某key自减
     * @param prefix
     * @param key
     * @return
     */
    public long decreaseWithPrefix(String prefix,String key) {
        return jedisCluster.decr(prefix + KEY_SPLIT + key);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean keyExist(String key ) {
        return jedisCluster.exists(key);
    }

    /**
     * 判断key是否存在
     * @param prefix
     * @param key
     * @return
     */
    public boolean keyExistWithPrefix(String prefix,String key) {
        return jedisCluster.exists(prefix + KEY_SPLIT + key);
    }

    public long expire(String prefix,String key,int expireTime){
        return jedisCluster.expire(prefix + KEY_SPLIT + key, expireTime);
    }

    /**
     *
     * @Description 从左往list中插入一值
     * @param key
     * @param value
     * @return
     */
    public long lpush(String prefix,String key,String... value ){
        return jedisCluster.lpush(prefix + KEY_SPLIT + key, value);
    }

    /**
     *
     * @Description 从右往list中插入一值
     * @param key
     * @param value
     * @return
     */
    public long rpush(String prefix,String key,String... value ){
        return jedisCluster.rpush(prefix + KEY_SPLIT + key, value);
    }

    /**
     *
     * @Description 获取指定长度list数据
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String prefix, String key, long start, long end){
        return jedisCluster.lrange(prefix + KEY_SPLIT + key, start, end);
    }

    /**
     *
     * @Description 从右端pop出一个数据
     * @param key
     * @return
     */
    public String rpop(String prefix,String key){
        return jedisCluster.rpop(prefix + KEY_SPLIT + key);
    }

    /**
     *
     * @Description 获取指定key下的长度
     * @param key
     * @return
     */
    public long llen(String prefix,String key){
        return jedisCluster.llen(prefix + KEY_SPLIT + key);
    }



}
