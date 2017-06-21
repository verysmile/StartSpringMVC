package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * by chenyufeng on 2017/6/21 .
 */
public class JSONParse04 {

    /**
     * 解析JSON对象，JSON.parseObject等同于JSONObject.parseObject
     * @param args
     */
    public static void main(String[] args) {

        String jsonString = "{\"type\":\"Boolean\",\"value1\":\"true\",\"value2\":\"false\"}";

        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println("jsonObject:" + jsonObject);

        JSONObject jsonObject1 = JSONObject.parseObject(jsonString);
        System.out.println("jsonObject1:" + jsonObject1);
    }
}
