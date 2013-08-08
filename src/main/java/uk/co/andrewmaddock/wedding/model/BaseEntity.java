package uk.co.andrewmaddock.wedding.model;

import java.io.Serializable;

/**
 * Domain object interface representing a base entity.
 *
 * @author Andrew Maddock
 *         Date: 22/07/13 17:22
 */
public interface BaseEntity extends Serializable {

    void setId(Long id);

    Long getId();

}
