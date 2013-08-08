package uk.co.andrewmaddock.wedding.service.email.gae;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.service.email.AbstractEmailService;
import uk.co.andrewmaddock.wedding.service.email.MailerService;

import static java.lang.String.format;

/**
 * GAE implementation of the {@link uk.co.andrewmaddock.wedding.service.email.EmailService} interface for {@link Rsvp} domain objects.
 *
 * @author Andrew Maddock
 *         Date: 31/07/13 13:44
 */
@Service
public class RsvpEmailServiceGae extends AbstractEmailService<Rsvp> {

    @Override
    public String emailRecipient(Rsvp rsvp) {
        throw new UnsupportedOperationException(
                format("%s does not support sending emails to recipients", getClass().getCanonicalName()));
    }

    @Override
    public String emailBody(Rsvp rsvp) {
        final String newLine = System.getProperty("line.separator");
        return  "RSVP" + newLine + newLine +
                "Names: " + rsvp.getNames() + newLine + 
                "Attending: " + rsvp.isAttending() + newLine + 
                "Adults: " + rsvp.getAdults() + newLine + 
                "Children: " + rsvp.getChildren() + newLine + 
                "Transport: " + rsvp.isTransport() + newLine + 
                "Message: " + rsvp.getMessage() + newLine;
    }
    
    @Autowired
    public RsvpEmailServiceGae(MailerService mailerService, VelocityEngine velocityEngine) {
        super(mailerService, velocityEngine);
    }
    
}
