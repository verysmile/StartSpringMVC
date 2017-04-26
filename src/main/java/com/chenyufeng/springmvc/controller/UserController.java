package com.chenyufeng.springmvc.controller;

import com.chenyufeng.springmvc.model.User;
import com.chenyufeng.springmvc.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * by chenyufeng on 2017/4/26 .
 */
@Api(value = "user", description = "用户", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @ApiOperation(value = "用户注册", notes = "用户", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveUser(
            @ApiParam(value = "用户名", required = true) @RequestParam String username,
            @ApiParam(value = "密码", required = true) @RequestParam String password
    ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.saveUser(user);

        return "success";
    }

    @ApiOperation(value = "所有用户", notes = "用户", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public List<User> listUser() {
        List<User> users = userService.findAllUsers();
        return users;
    }
}
