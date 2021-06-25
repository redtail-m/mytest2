package com.itheima.service;

import com.alibaba.fastjson.JSON;
import com.itheima.dao.ProvinceDao;
import com.itheima.pojo.Province;
import com.itheima.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zlj
 * @create 2021-05-28 11:33
 **/
public class ProvinceService {

    private ProvinceDao provinceDao = new ProvinceDao();

    public List<Province> findAll() throws SQLException {

        Jedis jedis = JedisUtil.getJedis();

        String province_list = jedis.get("province_list");

        if(province_list == null){

            List<Province> provinceList = provinceDao.findAll();

            String jsonString = JSON.toJSONString(provinceList);

            jedis.set("province_list",jsonString);
        }

        jedis.close();

        return JSON.parseArray(province_list,Province.class);
    }
}