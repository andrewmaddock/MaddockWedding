package uk.co.andrewmaddock.wedding.service.email;

import uk.co.andrewmaddock.wedding.model.BaseEntity;
import uk.co.andrewmaddock.wedding.service.ServiceException;

/**
 * Email service interface.
 *
 * @author Andrew Maddock
 *         Date: 31/07/13 15:07
 */
public interface EmailService<T extends BaseEntity> {
    
    void email(T domainObject) throws ServiceException;
    
}
