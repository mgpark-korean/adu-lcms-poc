package com.unicon.modulith.question.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class QuestionContent {

  private String headerContent;

  private String questionContent;

  private String answerContent;

  private String explanationContent;

  private String referenceContent;

  private String hintContent;

}
