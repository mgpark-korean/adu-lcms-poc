package com.unicon.modulith.question.service;

import com.unicon.modulith.common.annotation.UseCase;
import com.unicon.modulith.question.event.ResourceVerificationEvent;
import com.unicon.modulith.question.service.model.Question;
import com.unicon.modulith.question.service.model.QuestionResourceLink;
import com.unicon.modulith.question.service.port.in.QuestionCrudUseCase;
import com.unicon.modulith.question.service.port.out.QuestionCrudPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@UseCase
@RequiredArgsConstructor
public class QuestionService implements QuestionCrudUseCase {

  private final QuestionCrudPort questionCrudPort;

  private final ApplicationEventPublisher eventPublisher;

  @Override
  public List<Question> getQuestions() {
    return questionCrudPort.getQuestions();
  }

  @Override
  public Question getQuestion(Long id) {
    return questionCrudPort.getQuestion(id);
  }

  @Override
  public Question createQuestion(Question question) {
    this.verifyResources(question.resourceLinks());
    return questionCrudPort.createQuestion(question);
  }

  /**
   * Verify resources.
   *
   * @param questionResourceLinks question resource links
   */
  private void verifyResources(List<QuestionResourceLink> questionResourceLinks) {
    questionResourceLinks.forEach(questionResourceLink ->
        eventPublisher.publishEvent(
            new ResourceVerificationEvent(questionResourceLink.resourceId())));
  }

  @Override
  public Question updateQuestion(Question question) {
    return questionCrudPort.updateQuestion(question);
  }

  @Override
  public void deleteQuestion(Long id) {
    questionCrudPort.deleteQuestion(id);
  }

  @Override
  public void deleteQuestions(List<Long> ids) {
    questionCrudPort.deleteQuestions(ids);
  }
}
