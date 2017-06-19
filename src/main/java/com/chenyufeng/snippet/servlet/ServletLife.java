package com.chenyufeng.snippet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * by chenyufeng on 2017/6/18 .
 */

/**
 * Servlet生命周期
 */
public class ServletLife extends HttpServlet{

    public ServletLife() {
        System.out.println("1. 我被创建了...");
    }

    @Override
    public void init() throws ServletException {
        super.init();

        System.out.println("2. init方法被调用...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        System.out.println("3. service方法被调用...");
    }

    /**
     * 在destroy中关闭或者销毁一个文件系统或者网络资源；
     * 该方法与init()一样，在servlet中只能被调用一次。
     */
    @Override
    public void destroy() {
        super.destroy();

        System.out.println("4. destroy方法被调用...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法被调用...");

        resp.getWriter().append("my second servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法被调用...");

        doGet(req, resp);
    }
}
