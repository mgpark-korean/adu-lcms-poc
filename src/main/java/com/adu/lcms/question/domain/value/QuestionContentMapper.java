package com.adu.lcms.question.domain.value;

import com.adu.lcms.question.service.model.QuestionContent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionContentMapper {


  public QuestionContent mapToModel(QuestionContentValue content) {
    return new QuestionContent(
        content.getHeaderContent(),
        content.getQuestionContent(),
        content.getAnswerContent(),
        content.getExplanationContent(),
        content.getReferenceContent(),
        content.getHintContent()
    );
  }

  public QuestionContentValue mapToValue(QuestionContent content) {
    return new QuestionContentValue(
        content.getHeaderContent(),
        content.getQuestionContent(),
        content.getAnswerContent(),
        content.getExplanationContent(),
        content.getReferenceContent(),
        content.getHintContent()
    );
  }
}
