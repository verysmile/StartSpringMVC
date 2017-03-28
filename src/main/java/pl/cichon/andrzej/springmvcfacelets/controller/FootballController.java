package pl.cichon.andrzej.springmvcfacelets.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/football")
public class FootballController {

	@RequestMapping(value = "/{teamname}", method=RequestMethod.GET)
    @ResponseBody public String foo(@PathVariable String teamname, HttpServletRequest request){
	    //获取请求的参数，需要和链接中的参数名一致
        //推荐使用HttpServletRequest的方式来获取参数，GET、POST的参数都可以接收

        String name = request.getParameter("name");
        String age = request.getParameter("age");

	    //组装JSON返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("age", age);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "gao");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);

        return jsonArray.toString();
	}
}
