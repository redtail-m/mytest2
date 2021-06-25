package com.itheima.dao;

import com.itheima.pojo.Province;
import com.itheima.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zlj
 * @create 2021-05-28 11:36
 **/
public class ProvinceDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    public List<Province> findAll() throws SQLException {

        String sql = "select * from province";

        List<Province> provinceList = queryRunner.query(sql, new BeanListHandler<>(Province.class));

        return provinceList;
    }
}