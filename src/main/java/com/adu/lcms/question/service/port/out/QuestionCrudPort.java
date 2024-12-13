package com.adu.lcms.question.service.port.out;

import com.adu.lcms.question.service.model.Question;
import java.util.List;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface QuestionCrudPort {

  List<Question> getQuestions();

  Question getQuestion(Long id);

  Question createQuestion(Question question);

  Question updateQuestion(Question question);

  void deleteQuestion(Long id);

  void deleteQuestions(List<Long> ids);
}
