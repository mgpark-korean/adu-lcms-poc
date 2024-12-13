package com.unicon.modulith.question.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.modulith.NamedInterface;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Getter
@NamedInterface("event")
public class ResourceVerificationEvent extends ApplicationEvent {

  private final Long resourceId;

  public ResourceVerificationEvent(Long resourceId) {
    super(resourceId);
    this.resourceId = resourceId;
  }
}