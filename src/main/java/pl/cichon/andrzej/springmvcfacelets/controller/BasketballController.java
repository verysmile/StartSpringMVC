package pl.cichon.andrzej.springmvcfacelets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * by chenyufeng on 2017/3/29 .
 */

@Controller
@RequestMapping("/basketball")
public class BasketballController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody public List<Student> me(HttpServletRequest request) {

        List<Student> list = new ArrayList<Student>();

        Student student = new Student(request.getParameter("name"), request.getParameter("age"));
        list.add(student);
        return list;
    }
}
