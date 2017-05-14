package com.chenyufeng.springmvc.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * by chenyufeng on 2017/3/29 .
 */
@Api(value = "basketball", description = "篮球", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("basketball")
public class BasketballController {

    private static Logger logger = Logger.getLogger(BasketballController.class);

    @ApiOperation(value = "用户列表", notes = "列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Student> foo3(
            @ApiParam(value = "用户名", required = true) @RequestParam String name,
            @ApiParam(value = "年龄", required = true) @RequestParam String age
    ) {
        List<Student> list = new ArrayList<Student>();

        Student student = new Student(name, age);
        Student student1 = new Student(name + name, age + age);
        list.add(student);
        list.add(student1);
        return list;
    }

    /**
     * 在该方法中测试log4j
     *
     * @param teamname
     * @param request
     * @return
     */
    @RequestMapping(value = "v1.0/new/{teamname}", method = RequestMethod.GET)
    @ResponseBody public String foo4(@PathVariable String teamname, HttpServletRequest request) {

        //可以使用teamname获取url路径分隔

        //获取请求的参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Student student = new Student(name, age);

        //使用这种可以获得IP等其他信息放到log4j中，然后进行打印
        String remoteAddr = request.getRemoteAddr();
        NDC.push("NDC:" + remoteAddr);
        MDC.put("ip", "MDC:" + remoteAddr);

        //测试log4j
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.error("This is error message");

        NDC.pop();
        NDC.remove();

        MDC.remove("ip");

        return "123456";
    }

    @RequestMapping(value = "v2.0/new/{teamname}", method = RequestMethod.GET)
    @ResponseBody public Student foo5(@PathVariable String teamname, HttpServletRequest request) {

        //可以使用teamname获取url路径分隔

        //获取请求的参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Student student = new Student(name, age);

        return student;
    }

    @RequestMapping(value = "v3.0/new/{teamname}", method = RequestMethod.GET)
    @ResponseBody public List<Student> foo6(@PathVariable String teamname, HttpServletRequest request) {

        //可以使用teamname获取url路径分隔

        //获取请求的参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Student student = new Student(name, age);
        Student student1 = new Student(name + name, age + age);

        List<Student> list = new ArrayList<Student>();
        list.add(student);
        list.add(student1);

        return list;
    }


}
