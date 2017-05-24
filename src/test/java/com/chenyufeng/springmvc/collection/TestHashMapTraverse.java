package com.chenyufeng.springmvc.collection;

import org.junit.Test;

import java.util.HashMap;
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
}
