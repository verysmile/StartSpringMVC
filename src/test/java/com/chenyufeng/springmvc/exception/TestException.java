package com.chenyufeng.springmvc.exception;

import org.junit.Test;

/**
 * by chenyufeng on 2017/5/26 .
 */
public class TestException {

    /**
     * 构造某些方法的异常，需要通知外部
     * @param a
     * @throws Exception
     */
    public void testBaseParams(int a) throws Exception {
        if(a == 0) {
            throw new Exception("输入参数不能为0");
        }
    }

    /**
     * 调用某个抛出异常的方法，可以自己不处理，继续向外抛出
     * @throws Exception
     */
    public void testCallBaseparams() throws Exception {
        testBaseParams(0);
    }

    /**
     * 正确处理了抛出的异常，单测能通过
     */
    @Test
    public void testExcep1() {
        try {
            testCallBaseparams();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    /**
     * 没有处理异常，所以就会抛出异常；
     * 导致单测不能通过
     * @throws Exception
     */
    @Test
    public void testExcep2() throws Exception {
        testCallBaseparams();
    }

    /**
     * 测试自定义异常
     */
    public void test001() throws ValidationException {
        int a = 0;
        if(a == 0) {
            throw new ValidationException(BaseResult.Code.FAIL, "输入参数不能为0");
        }
    }

    @Test
    public void testCustomException01() throws ValidationException {
        test001();
    }

    @Test
    public void testCustomException02() {
        try {
            test001();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


}
