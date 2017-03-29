package pl.cichon.andrzej.springmvcfacelets.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/football")
public class FootballController {

	@RequestMapping(value = "/{teamname}", method=RequestMethod.GET)
    @ResponseBody public List<Student> foo(@PathVariable String teamname, HttpServletRequest request){
	    //获取请求的参数，需要和链接中的参数名一致
        //推荐使用HttpServletRequest的方式来获取参数，GET、POST的参数都可以接收
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        List<Student> list = new ArrayList<Student>();

        Student student = new Student(name, age);
        Student student1 = new Student(name + name, age + age);
        list.add(student);
        list.add(student1);
        return list;
	}
}
