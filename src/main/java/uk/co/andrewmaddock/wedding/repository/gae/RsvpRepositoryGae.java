package uk.co.andrewmaddock.wedding.repository.gae;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.repository.AbstractGenericRepository;
import uk.co.andrewmaddock.wedding.repository.RsvpRepository;

/**
 * GAE implementation of the {@link RsvpRepository} interface.
 *
 * @author Andrew Maddock
 *         Date: 18/07/13 13:42
 */
@Repository
public class RsvpRepositoryGae extends AbstractGenericRepository<Rsvp> implements RsvpRepository {

    @Override
    public void save(Rsvp rsvp) throws DataAccessException {
        if (!rsvp.isAttending()) {
            notAttending(rsvp);
        }
        super.save(rsvp);
    }

    private static void notAttending(Rsvp rsvp) {
        rsvp.setAdults(0);
        rsvp.setChildren(0);
        rsvp.setTransport(false);
    }

}
