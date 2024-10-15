package com.inha.springbootapp.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {

    String msg;
    int httpCode;
}