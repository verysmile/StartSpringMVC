package pl.cichon.andrzej.springmvcfacelets.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/football")
public class FootballController {

	@RequestMapping(value="/{teamname}", method=RequestMethod.GET)
    @ResponseBody public String foo(@PathVariable String teamname){

	    //组装JSON返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Jack");
        jsonObject.put("age", 12);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Mary");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);

        return jsonArray.toString();
	}
}
