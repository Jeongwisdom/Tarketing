package com.wisdom.tarketing.exception.errorcode;

import org.springframework.http.HttpStatus;

public enum MemberErrorCode implements ErrorCode {

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "회원을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    MemberErrorCode(HttpStatus httpStatus, String errorMessage) {
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
