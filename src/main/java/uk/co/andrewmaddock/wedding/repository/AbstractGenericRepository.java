package uk.co.andrewmaddock.wedding.repository;

import org.springframework.dao.DataAccessException;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import uk.co.andrewmaddock.wedding.model.BaseEntity;

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

    /**
     * Returns current Objectify which lets you load, save, and delete typed entities.
     * @return current Objectify
     */
    protected static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    /**
     * Returns Objectify factory which allows construction of implementations of the Objectify interface.
     * @return current Objectify factory
     */
    protected static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
    
}
