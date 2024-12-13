package com.unicon.modulith.question.domain;

import com.unicon.modulith.question.service.model.QuestionResourceLink;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Component
public class ResourceLinkMapper {


  public List<QuestionResourceLink> mapToModels(List<ResourceLinkEntity> resourceLinks) {
    return CollectionUtils.isEmpty(resourceLinks)
        ? Collections.emptyList()
        : resourceLinks.stream().map(this::mapToModel).toList();
  }

  public QuestionResourceLink mapToModel(ResourceLinkEntity entity) {
    return new QuestionResourceLink(
        entity.getResourceId()
    );
  }
}
