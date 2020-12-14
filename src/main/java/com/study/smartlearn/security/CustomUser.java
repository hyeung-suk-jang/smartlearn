package com.study.smartlearn.security;

import com.study.smartlearn.domain.Member;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

@Getter
public class CustomUser extends User {

    private Member member;

    public CustomUser(Member member) {
        super(member.getUid(), member.getPassword(), member.getRoles().stream()
                .map(memberRole -> new SimpleGrantedAuthority(memberRole.getRoleName())).collect(Collectors.toList()));

        this.member = member;
    }
}