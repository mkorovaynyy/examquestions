package org.skypro.examquestions.service;

import org.skypro.examquestions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
