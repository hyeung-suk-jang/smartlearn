package com.study.smartlearn.dto;

import com.study.smartlearn.domain.Member;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class MemberDto {

    private String uid;

    private String password;

    private String nickName;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .uid(uid)
                .nickName(nickName)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
