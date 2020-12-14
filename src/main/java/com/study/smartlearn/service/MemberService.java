package com.study.smartlearn.service;

import com.study.smartlearn.domain.Member;
import com.study.smartlearn.domain.MemberRole;
import com.study.smartlearn.dto.MemberDto;
import com.study.smartlearn.repository.MemberRepository;
import com.study.smartlearn.security.MemberRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;

    public void store(MemberDto memberDto) {
        Member member = memberDto.toEntity(passwordEncoder);
        MemberRole memberRole = MemberRole.builder().roleName("ROLE_MEMBER").build();
        memberRole.setMember(member);
        memberRoleRepository.save(memberRole);

        memberRepository.save(member);
    }

    public boolean nickNameChecker(String nickName) {
        return memberRepository.findByNickName(nickName).isPresent();
    }
}
