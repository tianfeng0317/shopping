package com.shopping.demo.base.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author :tianfeng
 * @Date : 2020/12/2 14:24
 * @Description:
 */
@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisCluster getJedisCluster(RedisConfig redisConfig) {
        String[] serverArray = redisConfig.getNodes().split(",");// 获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
//		return new JedisCluster(nodes, genericObjectPoolConfig());
        return new JedisCluster(nodes, 5000, 5000, 5000, redisConfig.getPassword(), genericObjectPoolConfig());
    }

    /**
     * 初始化连接池
     *
     * @return
     */
    private GenericObjectPoolConfig genericObjectPoolConfig() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getMaxTotal());
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMinIdle(redisConfig.getMinIdle());
        poolConfig.setMaxWaitMillis(redisConfig.getMaxWait());
        poolConfig.setTestOnBorrow(redisConfig.isTestOnBorrow());
        poolConfig.setTestOnReturn(redisConfig.isTestOnReturn());
        return poolConfig;
    }



}
