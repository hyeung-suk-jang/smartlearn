package com.study.smartlearn.service;

import com.study.smartlearn.domain.Example;
import com.study.smartlearn.domain.Question;
import com.study.smartlearn.dto.QuestionDto;
import com.study.smartlearn.repository.ExampleRepository;
import com.study.smartlearn.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Integer.parseInt;

@Slf4j
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

    public void modifyQuestion(Long id, QuestionDto questionDto) {
        Question question = questionRepository.findById(id).get();

        questionBulkUpdate(questionDto, question);
        questionRepository.save(question);

        if(parseInt(question.getCountExample()) > 2) {
            exampleRepository.deleteAllByQuestionId(id);
            List<Example> examples = questionDto.getExamples();
            for (Example example : examples) {
                example.setQuestion(question);
                exampleRepository.save(example);
            }
        }
    }

    private void questionBulkUpdate(QuestionDto questionDto, Question question) {
        question.setTitle(questionDto.getTitle());
        question.setQuestion(questionDto.getQuestion());
        question.setAnswer(questionDto.getAnswer());
        question.setUpdatedDate(LocalDate.now());
    }
}
