package test;

import org.junit.jupiter.api.Test;
import org.skypro.examquestions.model.Question;
import org.skypro.examquestions.service.ExaminerServiceImpl;
import org.skypro.examquestions.service.JavaQuestionService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExaminerServiceImplTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(javaQuestionService);

    @Test
    void testGetQuestions() {
        javaQuestionService.add("Что такое Java?", "Язык программирования");
        javaQuestionService.add("Что такое Spring?", "Фреймворк");
        Collection<Question> questions = examinerService.getQuestions(2);
        assertEquals(2, questions.size());
    }

    @Test
    void testGetQuestionsThrowsException() {
        javaQuestionService.add("Что такое Java?", "Язык программирования");
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(2));
    }
}
