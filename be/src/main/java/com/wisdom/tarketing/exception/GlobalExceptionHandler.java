package com.wisdom.tarketing.exception;

import com.wisdom.tarketing.exception.errorcode.CommonErrorCode;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.warn("CustomException - name: {}, message: {}", e.getErrorCode().getCode(),
                e.getErrorCode().getErrorMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return ResponseEntity.status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("exception: ", e);
        List<ErrorResponse.FieldError> errors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            errors.add(new ErrorResponse.FieldError(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        ErrorResponse errorResponse = new ErrorResponse(CommonErrorCode.BAD_REQUEST, errors);
        return ResponseEntity.status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }
}
