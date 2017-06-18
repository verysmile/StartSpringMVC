package com.chenyufeng.snippet.servlet;

/**
 * by chenyufeng on 2017/6/18 .
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet是单实例多线程的，所以有可能引发多线程问题
 */
public class ServletMultiThread extends HttpServlet{

    private int num = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //可以通过加锁解决并发访问的问题
        synchronized (this) {
            num++;
            try {
                Thread.sleep(2000);
                resp.getWriter().append(this.toString() + "；     ").append("num=" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
