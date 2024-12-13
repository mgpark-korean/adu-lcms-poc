package com.unicon.modulith.resource.domain;

import com.unicon.modulith.resource.domain.value.ResourceFileValue;
import com.unicon.modulith.resource.service.model.Resource;
import com.unicon.modulith.resource.service.model.ResourceType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Entity
@Getter
@Table(name = "resource")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResourceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  @Enumerated(EnumType.STRING)
  private ResourceType type;

  @Embedded
  private ResourceFileValue file;

  private ResourceEntity(String name, String description, ResourceType type,
      ResourceFileValue file) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.file = file;
  }

  /**
   * Create resource entity.
   *
   * @param resource the resource
   * @return the resource entity
   */
  public static ResourceEntity create(Resource resource) {
    return new ResourceEntity(
        resource.name(),
        resource.description(),
        resource.type(),
        ResourceFileValue.create(resource.file())
    );
  }

  /**
   * Update.
   *
   * @param resource the resource
   */
  public void update(Resource resource) {
    this.name = resource.name();
    this.description = resource.description();
    this.type = resource.type();

    if(Objects.isNull(this.file)) {
      this.file = ResourceFileValue.create(resource.file());
    } else {
      this.file.update(resource.file());
    }
  }
}
