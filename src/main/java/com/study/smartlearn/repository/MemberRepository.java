package com.study.smartlearn.repository;

import com.study.smartlearn.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUid(String uid);

    Optional<Member> findByNickName(String nickName);
}
