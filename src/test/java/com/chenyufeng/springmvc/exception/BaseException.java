package com.chenyufeng.springmvc.exception;

import com.chenyufeng.springmvc.exception.BaseResult.Code;
import org.apache.poi.ss.formula.functions.T;

/**
 * by chenyufeng on 2017/5/26 .
 */
public class BaseException extends Exception {

    protected Code code;

    protected BaseResult<T> baseResult;

    protected BaseException() {
        super();
    }

    protected BaseException(Code code) {
        super(code.getMsg());
        this.code = code;
        this.baseResult = new BaseResult<T>(code);
    }

    protected BaseException(Code code, String errorValue) {
        super(code.getMsg() + "\n" + errorValue);
        this.code = code;
        this.baseResult = new BaseResult<T>();
        this.baseResult.setMessage(code.getMsg() + " | " + errorValue);
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public BaseResult<T> getBaseResult() {
        return baseResult;
    }

    public void setBaseResult(BaseResult<T> baseResult) {
        this.baseResult = baseResult;
    }
}
