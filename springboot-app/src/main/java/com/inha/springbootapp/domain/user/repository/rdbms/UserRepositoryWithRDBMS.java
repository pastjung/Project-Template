package com.inha.springbootapp.domain.user.repository.rdbms;

import com.inha.springbootapp.domain.user.entity.RDBMSUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryWithRDBMS extends JpaRepository<RDBMSUser, Long> {
    RDBMSUser findByUserName(String checkUserName);
}
