package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.entry.ResultBean;
import com.itheima.pojo.Province;
import com.itheima.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zlj
 * @create 2021-05-28 11:30
 **/
@WebServlet(urlPatterns = "/province")
public class ProvinceServlet extends HttpServlet {

    private ProvinceService provinceService = new ProvinceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            Class<? extends ProvinceServlet> clazz = this.getClass();

            Method method = clazz.getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);

            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ResultBean resultBean = new ResultBean(true);

        try {
            List<Province> provinceList = provinceService.findAll();

            resultBean.setData(provinceList);
        } catch (Exception e) {
            e.printStackTrace();

            resultBean.setFlag(false);

            resultBean.setErrorMsg("查询失败！");
        }

        String jsonString = JSON.toJSONString(resultBean);

        response.getWriter().write(jsonString);
    }
}
