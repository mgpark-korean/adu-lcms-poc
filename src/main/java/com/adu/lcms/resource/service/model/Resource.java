package com.adu.lcms.resource.service.model;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public record Resource(
        Long id,
        String name,
        String description,
        ResourceType type,
        ResourceFile file
) {

}
