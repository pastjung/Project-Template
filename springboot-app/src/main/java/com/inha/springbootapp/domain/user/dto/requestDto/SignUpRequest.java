package com.inha.springbootapp.domain.user.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignUpRequest {

    @NotBlank
    private String userName;

    private String email;
}
