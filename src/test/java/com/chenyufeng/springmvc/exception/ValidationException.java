package com.chenyufeng.springmvc.exception;

import com.chenyufeng.springmvc.exception.BaseResult.Code;

/**
 * by chenyufeng on 2017/5/26 .
 */
public class ValidationException extends BaseException {
    public ValidationException(Code code) {
        super(code);
    }

    public ValidationException(Code code, String errorValue) {
        super(code, errorValue);
    }
}
