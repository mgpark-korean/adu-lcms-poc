package com.adu.lcms.question.service.model;

import java.util.List;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public record Question(
    Long id,
    QuestionContent content,
    List<QuestionResourceLink> resourceLinks
) {

}
