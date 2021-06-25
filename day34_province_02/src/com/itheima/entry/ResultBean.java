package com.itheima.entry;

import java.io.Serializable;

/**
 * @author zlj
 * @create 2021-05-05 22:27
 **/
public class ResultBean implements Serializable {

    //表示服务器是否异常
    private Boolean flag;

    //表示这次请求处理的结果
    private Object data;

    //表示服务器的错误信息
    private String errorMsg;

    @Override
    public String toString() {
        return "ResultBean{" +
                "flag=" + flag +
                ", date=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object date) {
        this.data = date;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultBean(Object data, String errorMsg) {
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultBean(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultBean(Object data) {
        this.data = data;
    }

    public ResultBean(Boolean flag) {
        this.flag = flag;
    }

    public ResultBean(Boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }
}