package com.inha.springbootapp.domain.user.dto.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RDBMSUserVo {
    private Long userId;
    private String userName;
    private String email;
}