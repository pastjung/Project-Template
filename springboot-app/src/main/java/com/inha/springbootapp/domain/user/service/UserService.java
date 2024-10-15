package com.inha.springbootapp.domain.user.service;

import com.inha.springbootapp.domain.user.dto.requestDto.SignUpRequest;
import com.inha.springbootapp.domain.user.dto.responseDto.SignUpResponse;
import com.inha.springbootapp.domain.user.entity.RDBMSUser;
import com.inha.springbootapp.domain.user.repository.UserRepositoryWithRDBMS;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryWithRDBMS userRepositoryWithRDBMS;

    public SignUpResponse signUpToRDBMS(SignUpRequest signUpRequest) {
        String checkUserName = signUpRequest.getUserName();
        if (userRepositoryWithRDBMS.findByUserName(checkUserName) != null) {
            throw new IllegalArgumentException("중복된 이름 입니다.");
        }

        RDBMSUser rdbmsUser = RDBMSUser.builder()
                .userName(signUpRequest.getUserName())
                .email(signUpRequest.getEmail())
                .build();

        RDBMSUser savedUser = userRepositoryWithRDBMS.save(rdbmsUser);

        return new SignUpResponse(savedUser.getUserName());
    }
}
