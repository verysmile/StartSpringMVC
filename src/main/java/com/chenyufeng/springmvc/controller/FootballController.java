package com.chenyufeng.springmvc.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "football", description = "足球", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("football")
public class FootballController {

    @ApiOperation(value = "用户登录注册", notes = "用户", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<Student> foo(
            @ApiParam(value = "用户名", required = true) @RequestParam String name,
            @ApiParam(value = "年龄", required = true) @RequestParam String age
    ) {
        //获取请求的参数，需要和链接中的参数名一致
        //推荐使用HttpServletRequest的方式来获取参数，GET、POST的参数都可以接收
        List<Student> list = new ArrayList<Student>();

        Student student = new Student(name, age);
        Student student1 = new Student(name + name, age + age);
        list.add(student);
        list.add(student1);
        return list;
    }

    @ApiOperation(value = "用户登录注册2", notes = "用户2", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "customer/login", method = RequestMethod.POST)
    public String foo2(
            @ApiParam(value = "用户名", required = true) @RequestParam String name
    ) {
        return name;
    }
}
