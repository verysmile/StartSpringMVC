package com.chenyufeng.snippet.servlet;

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

        //可以获得发送过来的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.getWriter().append("username=").append(username).append(";password=").append(password);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
