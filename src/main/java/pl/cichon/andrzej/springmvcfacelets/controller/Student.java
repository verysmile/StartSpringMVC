package pl.cichon.andrzej.springmvcfacelets.controller;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * by chenyufeng on 2017/3/28 .
 */
@ApiModel(value = "学生对象", description = "student")
public class Student {

    @ApiModelProperty(value = "姓名", required = true)
    String name;
    @ApiModelProperty(value = "年龄", required = true)
    String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
