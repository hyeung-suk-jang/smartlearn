package com.study.smartlearn.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String question;
    private String countExample;
    private String answer;
    private String category;

    private LocalDate createdDate;
    private LocalDate updatedDate;

    @OneToMany(mappedBy = "question")
    private List<Example> examples;
}
