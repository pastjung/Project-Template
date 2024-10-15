package com.inha.springbootapp.domain.user.controller;

import com.inha.springbootapp.domain.common.dto.CommonResponse;
import com.inha.springbootapp.domain.user.dto.requestDto.SignUpRequest;
import com.inha.springbootapp.domain.user.dto.responseDto.SignUpResponse;
import com.inha.springbootapp.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup/RDBMS")
    public ResponseEntity<CommonResponse<SignUpResponse>> signUpToRDBMS(@RequestBody @Validated SignUpRequest signUpRequest) {
        SignUpResponse signUpResponse = userService.signUpToRDBMS(signUpRequest);
        return CommonResponse.ofDataWithHttpStatus(signUpResponse, HttpStatus.OK);
    }
}
