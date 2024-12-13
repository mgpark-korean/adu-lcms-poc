package com.adu.lcms.question;

import com.adu.lcms.question.event.ResourceVerificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
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
public class QuestionModule {

  private final ApplicationEventPublisher eventPublisher;

  public void verifyResource(Long resourceId) {
    log.info("Verify resource: {}", resourceId);
    eventPublisher.publishEvent(new ResourceVerificationEvent(resourceId));
  }
}
