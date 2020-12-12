package com.study.smartlearn.dto;

import com.study.smartlearn.domain.Example;
import com.study.smartlearn.domain.Question;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuestionDto {
    private Long id;
    private String question;
    private String answer;
    private String countExample;
    private String category;

    private List<Example> examples;

    public Question toEntity() {
        return Question.builder()
                .question(question)
                .answer(answer)
                .countExample(countExample)
                .examples(examples)
                .category(category)
                .createdDate(LocalDate.now())
                .updatedDate(LocalDate.now())
                .build();
    }
}