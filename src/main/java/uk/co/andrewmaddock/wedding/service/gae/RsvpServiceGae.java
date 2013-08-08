package uk.co.andrewmaddock.wedding.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.repository.RsvpRepository;
import uk.co.andrewmaddock.wedding.service.AbstractGenericService;
import uk.co.andrewmaddock.wedding.service.RsvpService;
import uk.co.andrewmaddock.wedding.service.ServiceException;
import uk.co.andrewmaddock.wedding.service.email.EmailService;

/**
 * GAE implementation of the {@link RsvpService} interface.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class RsvpServiceGae extends AbstractGenericService<Rsvp> implements RsvpService {
    
    private final EmailService<Rsvp> emailService;

    @Override
    public void email(Rsvp rsvp) throws ServiceException {
        try {
            emailService.email(rsvp);
        } catch (Exception e) {
            LOG.error("RsvpServiceGae", "email", e);
            throw new ServiceException(e);
        }
    }

    @Autowired
    public RsvpServiceGae(RsvpRepository rsvpRepository, EmailService<Rsvp> emailService) {
        super(rsvpRepository);
        this.emailService = emailService;
    }
    
}
