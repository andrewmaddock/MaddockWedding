package uk.co.andrewmaddock.wedding.service;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.service.email.EmailService;

/**
 * Service interface for {@link Rsvp} domain objects.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:43
 */
public interface RsvpService extends GenericService<Rsvp>, EmailService<Rsvp> {
    
}
