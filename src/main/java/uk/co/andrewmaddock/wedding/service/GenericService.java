package uk.co.andrewmaddock.wedding.service;

import org.springframework.transaction.annotation.Transactional;

import uk.co.andrewmaddock.wedding.model.BaseEntity;

/**
 * Generic service interface for domain objects.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 11:50
 */
public interface GenericService<T extends BaseEntity> {

    @Transactional
    void save(T domainObject) throws ServiceException;    
    
}
