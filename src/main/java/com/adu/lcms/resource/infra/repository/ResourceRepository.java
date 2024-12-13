package com.adu.lcms.resource.infra.repository;

import com.adu.lcms.resource.domain.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

}
