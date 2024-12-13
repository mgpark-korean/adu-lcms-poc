package com.adu.lcms.question.domain;

import com.adu.lcms.question.domain.value.QuestionContentMapper;
import com.adu.lcms.question.service.model.Question;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
public class QuestionMapper {

  private final QuestionContentMapper contentMapper;
  private final ResourceLinkMapper resourceLinkMapper;

  public List<Question> mapToModels(List<QuestionEntity> entities) {
    return CollectionUtils.isEmpty(entities)
        ? Collections.emptyList()
        : entities.stream().map(this::mapToModel).toList();
  }

  public Question mapToModel(QuestionEntity entity) {
    return Objects.isNull(entity) ? null
        : new Question(
            entity.getId(),
            contentMapper.mapToModel(entity.getContent()),
            resourceLinkMapper.mapToModels(entity.getResourceLinks())
        );
  }
}
