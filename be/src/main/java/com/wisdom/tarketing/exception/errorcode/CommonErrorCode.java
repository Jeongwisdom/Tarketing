package com.wisdom.tarketing.exception.errorcode;

import org.springframework.http.HttpStatus;

public enum CommonErrorCode implements ErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    CommonErrorCode(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
