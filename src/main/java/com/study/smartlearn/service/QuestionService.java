package com.study.smartlearn.service;

import com.study.smartlearn.domain.Example;
import com.study.smartlearn.domain.Question;
import com.study.smartlearn.dto.QuestionDto;
import com.study.smartlearn.repository.ExampleRepository;
import com.study.smartlearn.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final ExampleRepository exampleRepository;
    private final QuestionRepository questionRepository;

    public void saveQuestion(QuestionDto questionDto) {
        Question question = questionDto.toEntity();
        questionRepository.save(question);

        List<Example> examples = questionDto.getExamples();
        if (examples != null) {
            for (Example example : examples) {
                example.setQuestion(question);
                exampleRepository.save(example);
            }
        }
    }

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question getPage(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
        return question;
    }
}
