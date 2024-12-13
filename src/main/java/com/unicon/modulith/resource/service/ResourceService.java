package com.unicon.modulith.resource.service;

import com.unicon.modulith.common.annotation.UseCase;
import com.unicon.modulith.resource.service.model.Resource;
import com.unicon.modulith.resource.service.port.in.ResourceCrudUseCase;
import com.unicon.modulith.resource.service.port.in.ResourceVerificationUseCase;
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
@UseCase
@RequiredArgsConstructor
public class ResourceService
    implements ResourceCrudUseCase, ResourceVerificationUseCase {

  private final ResourceCrudPort resourceCrudPort;

  /**
   * <p> get all resources. </p>
   *
   * @return List<Resource>
   */
  @Override
  public List<Resource> getResources() {
    return resourceCrudPort.getResources();
  }

  /**
   * <p> get resource by id. </p>
   *
   * @param id resource id
   * @return Resource
   */
  @Override
  public Resource getResource(Long id) {
    return resourceCrudPort.getResource(id);
  }

  /**
   * <p> create resource. </p>
   *
   * @param resource resource to create
   * @return Resource
   */
  @Override
  public Resource createResource(Resource resource) {
    return resourceCrudPort.createResource(resource);
  }

  /**
   * <p> update resource. </p>
   *
   * @param resource resource to update
   * @return Resource
   */
  @Override
  public Resource updateResource(Resource resource) {
    return resourceCrudPort.updateResource(resource);
  }

  /**
   * <p> delete resource. </p>
   *
   * @param id resource id
   */
  @Override
  public void deleteResource(Long id) {
    resourceCrudPort.deleteResource(id);
  }

  /**
   * <p> delete resources. </p>
   *
   * @param ids resource ids
   */
  @Override
  public void deleteResources(List<Long> ids) {
    resourceCrudPort.deleteResources(ids);
  }

  @Override
  public void verifyResource(Long resourceId) {
    this.getResource(resourceId);
  }
}
