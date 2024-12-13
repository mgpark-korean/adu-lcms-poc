package com.unicon.modulith.question.domain.value;

import com.unicon.modulith.question.service.model.Question;
import com.unicon.modulith.question.service.model.QuestionContent;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Getter
@Embeddable
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionContentValue {

  private String headerContent;

  private String questionContent;

  private String answerContent;

  private String explanationContent;

  private String referenceContent;

  private String hintContent;

  public static QuestionContentValue create(QuestionContent content) {
    return new QuestionContentValue(
        content.getHeaderContent(),
        content.getQuestionContent(),
        content.getAnswerContent(),
        content.getExplanationContent(),
        content.getReferenceContent(),
        content.getHintContent());
  }

  public void update(QuestionContent content) {
    this.headerContent = content.getHeaderContent();
    this.questionContent = content.getQuestionContent();
    this.answerContent = content.getAnswerContent();
    this.explanationContent = content.getExplanationContent();
    this.referenceContent = content.getReferenceContent();
    this.hintContent = content.getHintContent();
  }
}
