package com.unicon.modulith.question.persistence;

import com.unicon.modulith.common.annotation.PersistenceAdapter;
import com.unicon.modulith.question.infra.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class QuestionPersistentAdapter {

  private final QuestionRepository questionRepository;


}
