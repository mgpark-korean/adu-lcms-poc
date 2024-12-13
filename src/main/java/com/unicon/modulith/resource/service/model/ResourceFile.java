package com.unicon.modulith.resource.service.model;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public record ResourceFile(
    String fileName,
    String filePath,
    String fileContentType,
    Long fileSize,
    String fileExtension
) {

}
