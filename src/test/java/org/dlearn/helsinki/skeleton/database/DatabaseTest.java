package org.dlearn.helsinki.skeleton.database;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import org.dlearn.helsinki.skeleton.model.Question;
import org.dlearn.helsinki.skeleton.model.Survey;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aopkarja
 */
public class DatabaseTest {
    private final Database db = new Database();

    @Test
    public void testPostingSurveyQuestions() throws Exception {
        Survey survey = new Survey(){{
          this.title = "The salt of life";
          this.description = "What can you learn from nothing?";
          this.open = true;
        }};
        db.postSurvey(survey);
        List<Question> questions = Arrays.asList(new Question(){{
            this.question = "Do you like trains?";
            this.min_answer = 7;
            this.max_answer = 42;
        }});
        db.postSurveyQuestions(questions, survey);
        List<Question> questionsFromDb = db.getQuestionsFromSurvey(survey._id);
        
        assertEquals(1, questionsFromDb.size());
        assertEquals(questions.get(0).question, questionsFromDb.get(0).question);
        assertEquals(questions.get(0).min_answer, questionsFromDb.get(0).min_answer);
        assertEquals(questions.get(0).max_answer, questionsFromDb.get(0).max_answer);
    }
    
}
