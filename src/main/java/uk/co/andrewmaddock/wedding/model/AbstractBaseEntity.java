package uk.co.andrewmaddock.wedding.model;

import com.googlecode.objectify.annotation.Id;

/**
 * Generic domain object representing a base entity.
 *
 * @author Andrew Maddock
 *         Date: 09/08/13 13:55
 */
public class AbstractBaseEntity implements BaseEntity {

    private static final long serialVersionUID = -7923487235342505123L;

    @Id
    private Long id;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
    
}
