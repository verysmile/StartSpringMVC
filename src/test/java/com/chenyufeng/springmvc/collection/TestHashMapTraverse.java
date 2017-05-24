package com.chenyufeng.springmvc.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * by chenyufeng on 2017/5/24 .
 */
public class TestHashMapTraverse {

    /**
     * 遍历HashMap
     */
    @Test
    public void testHashMapTraverse() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "11");
        map.put(2, "22");

        //遍历键
        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }

        //遍历值
        for (String s : map.values()) {
            System.out.println(s);
        }
    }

    @Test
    public void testHashMap_List() {

        String aaa = "aaa";
        String bbb = "bbb";

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add(aaa);

        List<String> list2 = new ArrayList<String>();
        list2.add(bbb);

        map.put("1", list1);
        map.put("2", list2);

        //移除list中的值，最后虽然list为空，但是键还是存在的，值是一个空的列表
        list1.remove(aaa);

        for (String s : map.keySet()) {
            System.out.println("键：" + s);
        }

        for (List<String> list : map.values()) {
            System.out.println("值：" + list);
        }

        System.out.println("=======================");

        //删除键为1的键值对
        map.remove("1");

        for (String s : map.keySet()) {
            System.out.println("键：" + s);
        }

        for (List<String> list : map.values()) {
            System.out.println("值：" + list);
        }

    }
}
