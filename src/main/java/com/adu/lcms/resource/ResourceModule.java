package com.adu.lcms.resource;

import com.adu.lcms.question.event.ResourceVerificationEvent;
import com.adu.lcms.resource.service.port.in.ResourceVerificationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ResourceModule {

  private final ResourceVerificationUseCase resourceVerification;

  @EventListener
  public void verifyResource(ResourceVerificationEvent event) {
    System.out.println("Verify resource: " + event.getResourceId());
    resourceVerification.verifyResource(event.getResourceId());
  }
}
