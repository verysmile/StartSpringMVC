package com.chenyufeng.springmvc.exception;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * by chenyufeng on 2017/5/26 .
 */
@SuppressWarnings("unchecked")
public class BaseResult<T> {

    public enum Code {
        SUCCESS(0, "成功"),
        FAIL(1, "失败");
        private int code;
        private String msg;

        // 构造方法
        Code(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static String getMsgByCode(int code) {
            for (Code e : Code.values()) {
                if (e.getCode() == code) {
                    return e.msg;
                }
            }
            return null;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    @ApiModelProperty(value = "code - 返回代码：0表示成功，否则表示失败", dataType = "int")
    private int code;

    @ApiModelProperty(value = "message - 消息：如果code为0显示成功，否则显示错误信息", dataType = "string")
    private String message;

    @ApiModelProperty(value = "data - 数据：返回结果集", dataType = "JSON")
    private T data = (T) new Object();

    public BaseResult() {
        this.data = (T) new Object();
    }

    public BaseResult(String errorMsg) {
        this();
        this.code = 200;
        this.message = errorMsg;
    }

    public BaseResult(Code code) {
        this();
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    /**
     * 返回结果代码code和消息msg，不需要返回值
     * @param code 结果类型
     */
    public void returnWithoutValue(Code code) {
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    /**
     * 返回结果代码code和消息msg,并返回值
     * @param code   结果类型
     * @param Object   返回值
     */
    public void returnWithValue(Code code, T Object) {
        returnWithoutValue(code);
        this.data = Object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
