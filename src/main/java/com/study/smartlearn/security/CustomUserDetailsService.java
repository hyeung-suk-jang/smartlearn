package com.study.smartlearn.security;

import com.study.smartlearn.domain.Member;
import com.study.smartlearn.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Member member = memberRepository.findByUid(uid)
                .orElseThrow(() -> new NullPointerException("member를 찾지 못했습니다."));

        return new CustomUser(member);
    }
}