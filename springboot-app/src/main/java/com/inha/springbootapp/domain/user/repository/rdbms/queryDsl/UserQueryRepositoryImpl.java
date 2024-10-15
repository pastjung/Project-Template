package com.inha.springbootapp.domain.user.repository.rdbms.queryDsl;

import com.inha.springbootapp.domain.user.dto.vo.RDBMSUserVo;
import com.inha.springbootapp.domain.user.entity.QRDBMSUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository{
    private final JPAQueryFactory jpaQueryFactory;
    private final QRDBMSUser qrdbmsUser = QRDBMSUser.rDBMSUser;

    @Override
    public List<RDBMSUserVo> findAllUsers(String userEmail){
        return jpaQueryFactory
                .select(Projections.constructor(RDBMSUserVo.class,
                        qrdbmsUser.userId,
                        qrdbmsUser.userName,
                        qrdbmsUser.email))
                .from(qrdbmsUser)
//                .join(병합).on(조건)
                .where(qrdbmsUser.email.eq(userEmail))
                .orderBy(qrdbmsUser.modifiedAt.desc())
                .fetch();
    }
}
