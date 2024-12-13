package com.adu.lcms.resource.domain;

import com.adu.lcms.resource.domain.value.ResourceFileMapper;
import com.adu.lcms.resource.service.model.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
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
public class ResourceMapper {

  private final ResourceFileMapper fileMapper;

  public List<Resource> mapTpModels(List<ResourceEntity> models) {
    return CollectionUtils.isEmpty(models) ? Collections.emptyList()
        : models.stream().map(this::mapToModel).toList();
  }

  public Resource mapToModel(ResourceEntity entity) {
    return Objects.isNull(entity) ? null
        : new Resource(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getType(),
            fileMapper.mapToModel(entity.getFile())
        );
  }

  public ResourceEntity mapToEntity(Resource resource) {
    Assert.notNull(resource, "Resource must not be null");
    return new ResourceEntity(
            resource.id(),
            resource.name(),
            resource.description(),
            resource.type(),
            fileMapper.mapToEntity(resource.file())
        );
  }
}
