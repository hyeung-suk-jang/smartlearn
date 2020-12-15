package com.study.smartlearn.repository;

import com.study.smartlearn.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {
    void deleteAllByQuestionId(Long id);
}
