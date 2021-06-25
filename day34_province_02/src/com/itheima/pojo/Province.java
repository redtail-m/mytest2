package com.itheima.pojo;

import java.io.Serializable;

/**
 * @author zlj
 * @create 2021-05-28 11:34
 **/
public class Province implements Serializable {

    private Integer pid;
    private String pname;

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}