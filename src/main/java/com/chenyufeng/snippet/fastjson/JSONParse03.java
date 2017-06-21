package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * by chenyufeng on 2017/6/21 .
 */
public class JSONParse03 {

    /**
     * 这里也会抛出异常，jsonArray不能强转成jsonArray
     * @param args
     */
    public static void main(String[] args) {
        String jsonString = "[{\"type\":\"Boolean\",\"value1\":\"true\",\"value2\":\"false\"}]";

        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println("jsonObject:" + jsonObject);
    }
}
