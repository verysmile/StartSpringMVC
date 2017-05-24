package com.chenyufeng.springmvc.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

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

    /**
     * 测试HashMap的变量；以及List元素的删除
     */
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

    /**
     * 测试ConcurrentHashMap的遍历；以及删除ConcurrentLinkedQueue中的元素
     */
    @Test
    public void testConcurrentHashMap_ConcurrentLinkedQueue() {
        String aaa = "aaa";
        String bbb = "bbb";
        ConcurrentHashMap<Integer, ConcurrentLinkedQueue<String>> concurrentHashMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<String>>();

        ConcurrentLinkedQueue<String> queue1 = new ConcurrentLinkedQueue<String>();
        queue1.add(aaa);

        ConcurrentLinkedQueue<String> queue2 = new ConcurrentLinkedQueue<String>();
        queue2.add(bbb);

        concurrentHashMap.put(1, queue1);
        concurrentHashMap.put(2, queue2);

        for (Integer integer : concurrentHashMap.keySet()) {
            System.out.println("键：" + integer);
        }

        for (ConcurrentLinkedQueue<String> queue : concurrentHashMap.values()) {
            System.out.println("值：" + queue);
        }

        //只是删除列表中的一个值，使列表为空，但是对于map键值对并没有删除
        queue1.remove(aaa);
        System.out.println("=======================");
        for (Integer integer : concurrentHashMap.keySet()) {
            System.out.println("键：" + integer);
        }

        for (ConcurrentLinkedQueue<String> queue : concurrentHashMap.values()) {
            System.out.println("值：" + queue);
        }

        //删除键为1的键值对
        concurrentHashMap.remove(1);
        System.out.println("=======================");
        for (Integer integer : concurrentHashMap.keySet()) {
            System.out.println("键：" + integer);
        }

        for (ConcurrentLinkedQueue<String> queue : concurrentHashMap.values()) {
            System.out.println("值：" + queue);
        }
    }

    /**
     * 测试Hashmap中根据"值"删除键值对，如果有多个匹配，则只能删除一个键值对
     */
    @Test
    public void testRemoveElementFromValue() {
        Map<Integer, String>map = new HashMap<Integer, String>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "aaa");

        Collection<String> collection = map.values();
        collection.remove("aaa");

        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }
    }




}
