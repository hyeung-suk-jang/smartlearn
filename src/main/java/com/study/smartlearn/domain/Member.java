package com.study.smartlearn.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String uid;

    @Column(length = 100, nullable = false)
    private String password;

    private String nickName;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberRole> roles = new ArrayList<>();
}
