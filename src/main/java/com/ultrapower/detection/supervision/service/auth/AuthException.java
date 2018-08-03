package com.ultrapower.detection.supervision.service.auth;

import com.ultrapower.detection.supervision.exception.BaseException;

/**
 * Created by chengxj on 2015/10/19.
 */
public class AuthException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AuthException() {

    }

    public AuthException(String s) {
        super(s);
    }

    public AuthException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AuthException(Throwable throwable) {
        super(throwable);
    }

}
