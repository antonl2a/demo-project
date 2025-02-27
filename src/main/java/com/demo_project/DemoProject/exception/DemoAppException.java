package com.demo_project.DemoProject.exception;

public class DemoAppException extends RuntimeException {

    private final ApiErrorCode errorCode;
    public DemoAppException(String message, ApiErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DemoAppException(ApiErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public DemoAppException(ApiErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return errorCode.getStatusCode();
    }
}
