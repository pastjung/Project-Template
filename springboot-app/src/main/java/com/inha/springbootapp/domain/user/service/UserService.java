package com.inha.springbootapp.domain.user.service;

import com.inha.springbootapp.domain.user.dto.requestDto.SignUpRequest;
import com.inha.springbootapp.domain.user.dto.responseDto.SignUpResponse;
import com.inha.springbootapp.domain.user.dto.vo.RDBMSUserVo;
import com.inha.springbootapp.domain.user.entity.MongoDBUser;
import com.inha.springbootapp.domain.user.entity.RDBMSUser;
import com.inha.springbootapp.domain.user.repository.noSql.UserRepositoryWithMongoDB;
import com.inha.springbootapp.domain.user.repository.rdbms.UserRepositoryWithRDBMS;
import com.inha.springbootapp.domain.user.repository.rdbms.queryDsl.UserQueryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryWithRDBMS userRepositoryWithRDBMS;
    private final UserRepositoryWithMongoDB userRepositoryWithMongoDB;
    private final UserQueryRepository userQueryRepository;

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

    public SignUpResponse signUpToMongoDB(SignUpRequest signUpRequest) {
        String checkUserName = signUpRequest.getUserName();
        if (userRepositoryWithMongoDB.findByUserName(checkUserName) != null) {
            throw new IllegalArgumentException("중복된 이름 입니다.");
        }

        MongoDBUser mongoDBUser = MongoDBUser.builder()
                .userName(signUpRequest.getUserName())
                .email(signUpRequest.getEmail())
                .build();

        MongoDBUser savedUser = userRepositoryWithMongoDB.save(mongoDBUser);

        return new SignUpResponse(savedUser.getUserName());
    }

    public List<RDBMSUserVo> getAllUsersFromEmail(String email) {

        return userQueryRepository.findAllUsers(email);
    }
}
