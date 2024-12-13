package com.adu.lcms.question.service.port.in;

import com.adu.lcms.question.service.model.Question;
import java.util.List;

/**
 * <p> question C.R.U.D function use case. </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface QuestionCrudUseCase {

  /**
   * <p> Get all questions. </p>
   *
   * @return List of Question
   */
  List<Question> getQuestions();

  /**
   * <p> Get question by id. </p>
   *
   * @param id question id
   * @return Question
   */
  Question getQuestion(Long id);

  /**
   * <p> Create question. </p>
   *
   * @param question question record
   * @return Question
   */
  Question createQuestion(Question question);

  /**
   * <p> Update question. </p>
   *
   * @param question question record
   * @return Question
   */
  Question updateQuestion(Question question);

  /**
   * <p> Delete question by id. </p>
   *
   * @param id question id
   */
  void deleteQuestion(Long id);

  /**
   * <p> Delete questions by ids. </p>
   *
   * @param ids question ids
   */
  void deleteQuestions(List<Long> ids);
}
