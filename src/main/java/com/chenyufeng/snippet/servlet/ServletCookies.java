package com.chenyufeng.snippet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * by chenyufeng on 2017/6/19 .
 */
@WebServlet(name = "ServletCookies", urlPatterns = "/ServletCookies")
public class ServletCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("name:" + cookie.getName());
            System.out.println("value:" + cookie.getValue());
        }

        Cookie cookie = new Cookie("sessionId", "1234567890");
        cookie.setSecure(true);
        cookie.setMaxAge(-30);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
