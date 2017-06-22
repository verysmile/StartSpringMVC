package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * by chenyufeng on 2017/6/23 .
 */
public class JSONParse06 {

    /**
     * JSON字符串可以转化为POJO类对象；
     * @param args
     */
    public static void main(String[] args) {

        Person person = new Person("chenyufeng", "12");
        String s = JSON.toJSONString(person);
        System.out.println("s:" + s);

        Person person1 = JSON.parseObject(s, Person.class);
        System.out.println("person:" + person1.toString());
    }
}
