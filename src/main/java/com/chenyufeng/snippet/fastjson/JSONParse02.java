package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * by chenyufeng on 2017/6/21 .
 */
public class JSONParse02 {

    /**
     * 这里会抛出异常，因为parseArray接收的不是一个数组
     * @param args
     */
    public static void main(String[] args) {
        String jsonString = "{\"type\":\"Boolean\",\"value1\":\"true\",\"value2\":\"false\"}";
        JSONArray jsonArray = JSON.parseArray(jsonString);
        System.out.println("jsonArray:" + jsonArray);

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
