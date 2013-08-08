package uk.co.andrewmaddock.wedding.repository.gae;

import org.springframework.stereotype.Component;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.model.Rsvp;

/**
 * Objectify data source service registering entities and providing wrapper to Objectify instance.
 *
 * @author Andrew Maddock
 *         Date: 25/07/13 18:04
 */
@Component
public class OfyService {

    /**
     * Register all GAE domain model objects
     */
    static {
        factory().register(PlayList.class);
        factory().register(Rsvp.class);
    }

    /**
     * Returns current Objectify which lets you load, save, and delete typed entities
     * @return current Objectify
     */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    /**
     * Returns Objectify factory which allows construction of implementations of the Objectify interface
     * @return current Objectify factory
     */
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
    
}
