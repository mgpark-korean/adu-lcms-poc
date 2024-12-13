package com.unicon.modulith.resource.persistence;

import com.unicon.modulith.common.annotation.PersistenceAdapter;
import com.unicon.modulith.resource.domain.ResourceEntity;
import com.unicon.modulith.resource.domain.ResourceMapper;
import com.unicon.modulith.resource.infra.repository.ResourceRepository;
import com.unicon.modulith.resource.service.model.Resource;
import com.unicon.modulith.resource.service.port.out.ResourceCrudPort;
import java.util.List;
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
public class ResourceJpaAdapter implements ResourceCrudPort {

  private final ResourceRepository repository;
  private final ResourceMapper mapper;

  @Override
  public List<Resource> getResources() {
    return mapper.mapTpModels(repository.findAll());
  }

  @Override
  public Resource getResource(Long id) {
    return mapper.mapToModel(this.findById(id));
  }

  @Override
  public Resource createResource(Resource resource) {
    ResourceEntity savedEntity = repository.save(ResourceEntity.create(resource));
    return mapper.mapToModel(savedEntity);
  }

  @Override
  public Resource updateResource(Resource resource) {
    ResourceEntity entity = this.findById(resource.id());
    entity.update(resource);
    return mapper.mapToModel(entity);
  }

  @Override
  public void deleteResource(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteResources(List<Long> ids) {
    repository.deleteAllById(ids);
  }

  private ResourceEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found"));
  }
}
