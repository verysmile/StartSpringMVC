package com.chenyufeng.springmvc.collection;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * by chenyufeng on 2017/5/19 .
 */

/**
 * 四种方式遍历List
 */
public class TestListTraverse {

    private List<String> list = new ArrayList<String>();

    public TestListTraverse() {
        list.add("11");
        list.add("2");
        list.add("33");
        list.add("4");
        list.add("5");
    }

    /**
     * 直接使用迭代器
     */
    @Test
    public void testListTraverse1() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 不常见
     */
    @Test
    public void testListTraverse2() {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 这种方式最方便，直接使用iter即可
     */
    @Test
    public void testListTraverse3() {
        for (String string : list) {
            System.out.println(string);
        }
    }

    /**
     * 这种方式最直观，使用size()
     */
    @Test
    public void testListTraverse4() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 判断List遍历如果为NULL时是否会抛出异常;
     * 如果被遍历的List为空，则会抛出空指针异常，所以需要被初始化；
     *
     * 所以最好能进行异常处理
     */
    @Test
    public void testListIsNull() {

        List<String> list = null; //这里需要被初始化
        try {
            for (String s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
