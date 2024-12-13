package com.adu.lcms.resource.domain.value;

import com.adu.lcms.resource.service.model.ResourceFile;
import jakarta.persistence.Embeddable;
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
@Getter
@Embeddable
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResourceFileValue {

  private String fileName;

  private String filePath;

  private String fileContentType;

  private Long fileSize;

  private String fileExtension;


  public static ResourceFileValue create(ResourceFile file) {
    return new ResourceFileValue(
        file.fileName(),
        file.filePath(),
        file.fileContentType(),
        file.fileSize(),
        file.fileExtension());
  }

  public void update(ResourceFile file) {
    this.fileName = file.fileName();
    this.filePath = file.filePath();
    this.fileContentType = file.fileContentType();
    this.fileSize = file.fileSize();
    this.fileExtension = file.fileExtension();
  }
}
