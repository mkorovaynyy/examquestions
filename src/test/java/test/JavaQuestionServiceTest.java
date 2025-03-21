package test;

import org.junit.jupiter.api.Test;
import org.skypro.examquestions.model.Question;
import org.skypro.examquestions.service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void testAddQuestion() {
        Question question = javaQuestionService.add("Что такое Java?", "Язык программирования");
        assertNotNull(question);
        assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    void testRemoveQuestion() {
        javaQuestionService.add("Что такое Java?", "Язык программирования");
        Question removedQuestion = javaQuestionService.remove("Что такое Java?", "Язык программирования");
        assertNotNull(removedQuestion);
        assertEquals(0, javaQuestionService.getAll().size());
    }

    @Test
    void testGetRandomQuestion() {
        javaQuestionService.add("Что такое Java?", "Язык программирования");
        javaQuestionService.add("Что такое Spring?", "Фреймворк");
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
    }
}
