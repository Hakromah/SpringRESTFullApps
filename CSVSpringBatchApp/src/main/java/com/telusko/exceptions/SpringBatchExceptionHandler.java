package com.telusko.exceptions;

public class SpringBatchExceptionHandler extends RuntimeException {

    public SpringBatchExceptionHandler(String message) {
        super(message);
    }
}
