package com.chenyufeng.springmvc.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * by chenyufeng on 2017/3/29 .
 */
@Api(value = "basketball", description = "篮球", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("basketball")
public class BasketballController {
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
}
