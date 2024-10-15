package com.inha.springbootapp.domain.user.repository.rdbms.queryDsl;

import com.inha.springbootapp.domain.user.dto.vo.RDBMSUserVo;

import java.util.List;

public interface UserQueryRepository {
    List<RDBMSUserVo> findAllUsers(String userEmail);
}
