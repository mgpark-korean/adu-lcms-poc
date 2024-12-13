package com.adu.lcms.resource.service.port.in;

import com.adu.lcms.resource.service.model.Resource;
import java.util.List;

/**
 * <p> resource C.R.U.D user case </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface ResourceCrudUseCase {

  /**
   * <p> get all resources </p>
   *
   * @return List<Resource>
   */
  List<Resource> getResources();

  /**
   * <p> get resource by id </p>
   *
   * @param id resource id
   * @return Resource
   */
  Resource getResource(Long id);

  /**
   * <p> create resource </p>
   *
   * @param resource resource to create
   * @return Resource
   */
  Resource createResource(Resource resource);

  /**
   * <p> update resource </p>
   *
   * @param resource resource to update
   * @return Resource
   */
  Resource updateResource(Resource resource);

  /**
   * <p> delete resource </p>
   *
   * @param id resource id
   */
  void deleteResource(Long id);

  /**
   * <p> delete resources </p>
   *
   * @param ids resource ids
   */
  void deleteResources(List<Long> ids);
}
