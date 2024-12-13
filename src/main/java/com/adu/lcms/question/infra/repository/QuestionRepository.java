package com.adu.lcms.question.infra.repository;

import com.adu.lcms.question.domain.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
