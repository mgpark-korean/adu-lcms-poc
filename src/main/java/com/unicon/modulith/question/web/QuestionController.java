package com.unicon.modulith.question.web;

import com.unicon.modulith.common.annotation.WebAdapter;
import com.unicon.modulith.question.service.model.Question;
import com.unicon.modulith.question.service.port.in.QuestionCrudUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> QuestionEntity controller. </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

  private final QuestionCrudUseCase questionCrudUseCase;

  /**
   * Get questions.
   *
   * @return questions
   */
  @GetMapping("")
  public ResponseEntity<List<Question>> getQuestions() {
    return ResponseEntity.ok().body(questionCrudUseCase.getQuestions());
  }

  /**
   * Get question by id.
   *
   * @param id question id
   * @return question
   */
  @GetMapping("/{id}")
  public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
    return ResponseEntity.ok().body(questionCrudUseCase.getQuestion(id));
  }

  /**
   * Create question.
   *
   * @param question question record
   * @return created question
   */
  @PostMapping("")
  public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
    return ResponseEntity.ok().body(questionCrudUseCase.createQuestion(question));
  }

  /**
   * Update question.
   *
   * @param question question record
   * @return updated question
   */
  @PutMapping("")
  public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
    return ResponseEntity.ok().body(questionCrudUseCase.updateQuestion(question));
  }

  /**
   * Delete question by id.
   *
   * @param id question id
   * @return response entity
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
    questionCrudUseCase.deleteQuestion(id);
    return ResponseEntity.ok().build();
  }

  /**
   * Delete questions.
   *
   * @param ids question ids
   * @return response entity
   */
  @DeleteMapping("")
  public ResponseEntity<Void> deleteQuestions(List<Long> ids) {
    questionCrudUseCase.deleteQuestions(ids);
    return ResponseEntity.ok().build();
  }
}
