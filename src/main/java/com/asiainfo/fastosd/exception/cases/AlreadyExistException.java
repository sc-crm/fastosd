package com.asiainfo.fastosd.exception.cases;

import com.asiainfo.fastosd.exception.BaseException;

/**
 * @author Steven
 * @date 2019-04-26
 */
public class AlreadyExistException extends BaseException {
    public AlreadyExistException(String message, int code) {
        super(message, code);
    }
}
