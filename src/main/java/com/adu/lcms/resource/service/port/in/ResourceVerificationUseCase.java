package com.adu.lcms.resource.service.port.in;

/**
 * <p> resource verify use case. </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface ResourceVerificationUseCase {

    /**
     * <p> verify resource. </p>
     *
     * @param resourceId resource id
     * @return boolean
     */
    void verifyResource(Long resourceId);
}
