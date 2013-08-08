package uk.co.andrewmaddock.wedding.repository;

import org.springframework.dao.DataAccessException;

import uk.co.andrewmaddock.wedding.model.BaseEntity;

/**
 * Generic repository interface for domain objects.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 12:08
 */
public interface GenericRepository<T extends BaseEntity> {

    void save(T domainObject) throws DataAccessException;

}

