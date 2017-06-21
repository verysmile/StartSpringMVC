package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * by chenyufeng on 2017/6/21 .
 */
public class JSONParse05 {

    /**
     * 这里的案例是把对象转化成JSON字符串；
     * @param args
     */
    public static void main(String[] args) {

        //单个对象转化为JSONString
        Person person01 = new Person("chenyufeng","14");

        String s = JSON.toJSONString(person01);
        System.out.println("s:" + s);

        //List对象转化为JSONString
        List<String> list1 = new ArrayList<String>();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        String s3 = JSON.toJSONString(list1);
        System.out.println("s3:" + s3);

        //List对象转化为JSONString
        Person person02 = new Person("chenyufeng2","142");
        Person person03 = new Person("chenyufeng3","143");
        List<Person> list = new ArrayList<Person>();
        list.add(person01);
        list.add(person02);
        list.add(person03);

        String s1 = JSON.toJSONString(list);
        System.out.println("s1:" + s1);

        //Map对象转化为JSONString
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "chenyufeng");
        map.put("2", "gaowenjing");
        String s2 = JSON.toJSONString(map);
        System.out.println("s2:" + s2);

        //Map对象转化为JSONString
        Map<String, Person> map1 = new HashMap<String, Person>();
        map1.put("1", person01);
        map1.put("2", person02);
        map1.put("3", person03);
        String s4 = JSON.toJSONString(map1);
        System.out.println("s4:" + s4);
    }
}
