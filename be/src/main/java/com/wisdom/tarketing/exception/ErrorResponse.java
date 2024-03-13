package com.wisdom.tarketing.exception;

import com.wisdom.tarketing.exception.errorcode.ErrorCode;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final HttpStatus httpStatus;
    private final String code;
    private final String errorMessage;
    private List<FieldError> validation;

    public ErrorResponse(ErrorCode errorCode) {
        this.timestamp = LocalDateTime.now();
        this.httpStatus = errorCode.getHttpStatus();
        this.code = errorCode.getCode();
        this.errorMessage = errorCode.getErrorMessage();
    }

    public ErrorResponse(ErrorCode errorCode, List<FieldError> errors) {
        this.timestamp = LocalDateTime.now();
        this.httpStatus = errorCode.getHttpStatus();
        this.code = errorCode.getCode();
        this.errorMessage = errorCode.getErrorMessage();
        this.validation = errors;
    }

    @Getter
    @NoArgsConstructor
    public static class FieldError {

        private String field;
        private String message;

        public FieldError(String field, String defaultMessage) {
            this.field = field;
            this.message = defaultMessage;
        }
    }
}
