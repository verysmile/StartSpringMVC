package com.chenyufeng.springmvc.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * by chenyufeng on 2017/5/19 .
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

    @Test
    public void testListTraverse1() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testListTraverse2() {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testListTraverse3() {
        for (String string : list) {
            System.out.println(string);
        }
    }

    @Test
    public void testListTraverse4() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
