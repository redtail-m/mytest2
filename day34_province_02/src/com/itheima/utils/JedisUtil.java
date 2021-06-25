package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author zlj
 * @create 2021-05-27 20:37
 **/
public class JedisUtil {

    private static JedisPool jedisPool;
    private static String host;
    private static Integer port;
    private static Integer maxTotal;
    private static Integer maxIdle;
    private static Long maxWaitMillis;

    static{

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        //?
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jedis");

        host = resourceBundle.getString("host");
        port = Integer.valueOf(resourceBundle.getString("port"));
        maxTotal = Integer.valueOf(resourceBundle.getString("maxTotal"));
        maxIdle = Integer.valueOf(resourceBundle.getString("maxIdle"));
        maxWaitMillis = Long.valueOf(resourceBundle.getString("maxWaitMillis"));

        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        String host = "localhost";

        int port = 6379;

        //创建连接池对象
        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    //获取链接
    public static Jedis getJedis(){

        return jedisPool.getResource();
    }
}