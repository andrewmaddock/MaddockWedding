package uk.co.andrewmaddock.wedding.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import uk.co.andrewmaddock.wedding.model.BaseEntity;
import uk.co.andrewmaddock.wedding.repository.GenericRepository;

/**
 * Generic service for domain objects.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 11:59
 */
public abstract class AbstractGenericService<T extends BaseEntity> implements GenericService<T> {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractGenericService.class.getName());

    private final GenericRepository<T> repository;
    
    @Override
    @Transactional
    public void save(T domainObject) throws ServiceException {  
        try {
            repository.save(domainObject);
        } catch (Exception e) {
            LOG.error("AbstractGenericService", "save", e);
            throw new ServiceException(e);
        }
    }
    
    public AbstractGenericService(GenericRepository<T> repository) {
        this.repository = repository;    
    }
    
}
