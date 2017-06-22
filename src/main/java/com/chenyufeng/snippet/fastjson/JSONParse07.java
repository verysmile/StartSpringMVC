package com.chenyufeng.snippet.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * by chenyufeng on 2017/6/23 .
 */
public class JSONParse07 {

    /**
     * JSON数组字符串转化为List<T>对象；
     * @param args
     */
    public static void main(String[] args) {
        Person person = new Person("chen", "12");
        Person person1 = new Person("yufeng","24");

        List<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person1);

        String s = JSON.toJSONString(list);
        System.out.println("s:" + s);

        List<Person> list1 = JSON.parseArray(s, Person.class);
        System.out.println("list1:" + list1.toString());
    }
}
