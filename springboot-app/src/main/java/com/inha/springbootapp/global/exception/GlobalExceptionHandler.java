package com.inha.springbootapp.global.exception;

import com.inha.springbootapp.domain.common.dto.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(Exception ex) {
        ExceptionResponse response = ExceptionResponse.builder()
                .msg(ex.getMessage())
                .httpCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}