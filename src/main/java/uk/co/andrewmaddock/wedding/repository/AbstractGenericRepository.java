package uk.co.andrewmaddock.wedding.repository;

import org.springframework.dao.DataAccessException;

import uk.co.andrewmaddock.wedding.model.BaseEntity;

import static uk.co.andrewmaddock.wedding.repository.gae.OfyService.ofy;

/**
 * Generic repository for domain objects.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 12:15
 */
public class AbstractGenericRepository<T extends BaseEntity> implements GenericRepository<T> {

    @Override
    public void save(T domainObject) throws DataAccessException {
        ofy().save().entity(domainObject).now();
    }
    
}
