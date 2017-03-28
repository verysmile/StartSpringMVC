package pl.cichon.andrzej.springmvcfacelets.controller;

/**
 * by chenyufeng on 2017/3/28 .
 */
public class Student {

    String name;
    String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
