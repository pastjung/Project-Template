package com.inha.springbootapp.domain.user.controller;

import com.inha.springbootapp.domain.common.dto.CommonResponse;
import com.inha.springbootapp.domain.user.dto.requestDto.SignUpRequest;
import com.inha.springbootapp.domain.user.dto.responseDto.SignUpResponse;
import com.inha.springbootapp.domain.user.dto.vo.RDBMSUserVo;
import com.inha.springbootapp.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/signup/NoSQL")
    public ResponseEntity<CommonResponse<SignUpResponse>> signUpToMongoDB(@RequestBody @Validated SignUpRequest signUpRequest) {
        SignUpResponse signUpResponse = userService.signUpToMongoDB(signUpRequest);
        return CommonResponse.ofDataWithHttpStatus(signUpResponse, HttpStatus.OK);
    }

    @GetMapping("/getAllUsersFromEmail/queryDsl")
    public ResponseEntity<CommonResponse<List<RDBMSUserVo>>> getOrders(@RequestParam String email){
        List<RDBMSUserVo> rdbmsUserVoList = userService.getAllUsersFromEmail(email);
        return CommonResponse.ofDataWithHttpStatus(rdbmsUserVoList, HttpStatus.OK);
    }
}
