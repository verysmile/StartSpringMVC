package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * by chenyufeng on 2017/6/21 .
 */

/**
 [
 {
 "type":"Boolean",
 "value1":"true",
 "value2":"false"
 }
 ]
 */
public class JSONParse01 {

    /**
     * 解析JSON字符串数组，中括号表示的是数组，大括号表示的是对象
     * @param args
     */
    public static void main(String[] args) {
        //JSON.parseArray的作用等同于JSONArray.parseArray
        String jsonString = "[{\"type\":\"Boolean\",\"value1\":\"true\",\"value2\":\"false\"}]";
        JSONArray jsonArray = JSON.parseArray(jsonString);
        System.out.println("jsonArray:" + jsonArray);

        JSONArray jsonArray1 = JSONArray.parseArray(jsonString);
        System.out.println("jsonArray1:" + jsonArray1);

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println("1" + jsonArray.get(i));
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println("2" + jsonObject);

            String type = jsonObject.getString("type");
            System.out.println("type:" + type);

            String value = jsonObject.getString("value1");
            System.out.println("value1:" + value);

            String mayvalue = jsonObject.getString("value2");
            System.out.println("value2:" + mayvalue);
        }
    }
}


