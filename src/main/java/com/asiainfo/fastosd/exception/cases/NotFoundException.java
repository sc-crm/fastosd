package com.asiainfo.fastosd.exception.cases;

import com.asiainfo.fastosd.exception.BaseException;

/**
 * @author Steven
 */
public class NotFoundException extends BaseException {
    public NotFoundException(String message, int code) {
        super(message, code);
    }
}
