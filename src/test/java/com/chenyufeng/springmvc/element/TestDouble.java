package com.chenyufeng.springmvc.element;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * by chenyufeng on 2017/5/25 .
 */

/**
 * 设计原则：float和double只能用来做科学计算或者工程计算，在商业计算中要用BigDecimal
 */
public class TestDouble {

    /**
     * 这是非常极端的例子
     */
    @Test
    public void testDoubleCompare() {

        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);

    }

    /**
     * 非整型数， 运算由于精度问题，可能会有误差，建议使用BigDecimal；
     *
     * 比较时返回-1， 0，  1
     */
    @Test
    public void testBigDecimal() {
        double a = 0.001;
        double b = 0.0011;
        double c = 0.001100;

        BigDecimal decimalA = new BigDecimal(a);
        BigDecimal decimalB = new BigDecimal(b);
        BigDecimal decimalC = new BigDecimal(c);

        Assert.assertTrue(decimalA.compareTo(decimalB) < 0);
        Assert.assertTrue(decimalB.compareTo(decimalC) == 0);


        //如果需要精确计算，一定要用String来构造BigDecimal
        BigDecimal decimal01 = new BigDecimal(1.11);
        BigDecimal decimal02 = new BigDecimal("1.11");
    }

    /**
     * 使用Double类能正确比较大小
     */
    @Test
    public void testDouble() {
        Double double01 = new Double("8.5");
        Double double02 = new Double("11.50");

        Assert.assertTrue(double01.compareTo(double02) < 0);
    }

    /**
     * BigDecimal的double构造函数损失了double参数的精度，最后才导致了错误的结果。
     */
    @Test
    public void testDouble0_5() {
        /**
         * 以下方法会存在精度的损失
         */
        double d = 3.05;
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP));

        /**
         * BigDecimal使用String参数的构造函数，不会丢失精度
         */
        System.out.println(new BigDecimal(Double.toString(d)));
        System.out.println("3.05");
        System.out.println(new BigDecimal("3.04999999999999982236431605997495353221893310546875"));
    }

    /**
     * double对数据的处理，默认都会加一个小数点。整型的话会加一个.0
     */
    @Test
    public void testBigDecimal_zero() {

        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal bigDecimal1 = new BigDecimal(2.0);
        BigDecimal bigDecimal2 = new BigDecimal(2.00);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);

        double double1 = 2;
        double double2 = 2.0;
        double double3 = 2.00;
        System.out.println(double1);
        System.out.println(double2);
        System.out.println(double3);

    }
}
