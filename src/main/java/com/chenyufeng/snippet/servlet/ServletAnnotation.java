package com.chenyufeng.snippet.servlet;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * by chenyufeng on 2017/6/19 .
 */

/**
 * 可以通过注解配置Servlet，比使用配置文件方便
 */
@WebServlet(name = "ServletAnnotation", urlPatterns = "/ServletAnnotation")
public class ServletAnnotation extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("my third servlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
