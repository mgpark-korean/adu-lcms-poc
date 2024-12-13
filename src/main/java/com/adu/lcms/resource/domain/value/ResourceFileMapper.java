package com.adu.lcms.resource.domain.value;

import com.adu.lcms.resource.service.model.ResourceFile;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Component
public class ResourceFileMapper {

  public ResourceFile mapToModel(ResourceFileValue file) {
    return new ResourceFile(
        file.getFileName(),
        file.getFilePath(),
        file.getFileContentType(),
        file.getFileSize(),
        file.getFileExtension());
  }

  public ResourceFileValue mapToEntity(ResourceFile file) {
    return Objects.isNull(file) ? null
        : new ResourceFileValue(
            file.fileName(),
            file.filePath(),
            file.fileContentType(),
            file.fileSize(),
            file.fileExtension());
  }
}
