package org.skypro.examquestions.service;

import org.skypro.examquestions.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionToRemove = new Question(question, answer);
        if (questions.remove(questionToRemove)) {
            return questionToRemove;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("Нет вопросов в хранилище.");
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.stream()
                .skip(randomIndex)
                .findFirst()
                .orElseThrow();
    }
}
