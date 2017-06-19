package com.chenyufeng.snippet.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * by chenyufeng on 2017/6/19 .
 */
@WebServlet(name = "ForwardServlet", urlPatterns = "/ForwardServlet")
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 重定向请求到另一个Servlet
         */
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ForwardServletReceive");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
