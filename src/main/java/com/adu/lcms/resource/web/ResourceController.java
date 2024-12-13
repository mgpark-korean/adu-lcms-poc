package com.adu.lcms.resource.web;

import com.adu.lcms.common.annotation.WebAdapter;
import com.adu.lcms.resource.service.model.Resource;
import com.adu.lcms.resource.service.port.in.ResourceCrudUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/resources")
public class ResourceController {

  private final ResourceCrudUseCase resourceCrudUseCase;

  /**
   * <p> get all resources. </p>
   *
   * @return List<Resource>
   */
  @GetMapping("")
  public ResponseEntity<List<Resource>> getResources() {
    return ResponseEntity.ok().body(resourceCrudUseCase.getResources());
  }

  /**
   * <p> get resource by id. </p>
   *
   * @param id resource id
   * @return Resource
   */
  @GetMapping("/{id}")
  public ResponseEntity<Resource> getResource(@PathVariable Long id) {
    return ResponseEntity.ok().body(resourceCrudUseCase.getResource(id));
  }

  /**
   * <p> create resource. </p>
   *
   * @param resource resource to create
   * @return Resource
   */
  @PostMapping("")
  public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
    return ResponseEntity.ok().body(resourceCrudUseCase.createResource(resource));
  }

  /**
   * <p> update resource. </p>
   *
   * @param resource resource to update
   * @return Resource
   */
  @PutMapping("")
  public ResponseEntity<Resource> updateResource(@RequestBody Resource resource) {
    return ResponseEntity.ok().body(resourceCrudUseCase.updateResource(resource));
  }

  /**
   * <p> delete resource. </p>
   *
   * @param id resource id
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
    resourceCrudUseCase.deleteResource(id);
    return ResponseEntity.ok().build();
  }

  /**
   * <p> delete resources. </p>
   *
   * @param ids resource ids
   */
  @DeleteMapping("")
  public ResponseEntity<Void> deleteResources(@RequestBody List<Long> ids) {
    resourceCrudUseCase.deleteResources(ids);
    return ResponseEntity.ok().build();
  }
}
