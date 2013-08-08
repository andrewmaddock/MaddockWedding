package uk.co.andrewmaddock.wedding.service.email.gae;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.service.email.AbstractEmailService;
import uk.co.andrewmaddock.wedding.service.email.MailerService;

import static java.lang.String.format;

/**
 * GAE implementation of the {@link uk.co.andrewmaddock.wedding.service.email.EmailService} interface for {@link PlayList} domain objects.
 *
 * @author Andrew Maddock
 *         Date: 31/07/13 13:44
 */
@Service
public class PlayListEmailServiceGae extends AbstractEmailService<PlayList> {

    @Override
    public String emailRecipient(PlayList playList) {
        throw new UnsupportedOperationException(
                format("%s does not support sending emails to recipients", getClass().getCanonicalName()));
    }

    @Override
    public String emailBody(PlayList playList) {
        final String newLine = System.getProperty("line.separator");
        return  "Playlist Item" + newLine + newLine + 
                "Requester: " + playList.getRequester() + newLine + 
                "Artist: " + playList.getArtist() + newLine + 
                "Track: " + playList.getTrack() + newLine + 
                "Why: " + playList.getWhy() + newLine;
    }

    @Autowired
    public PlayListEmailServiceGae(MailerService mailerService, VelocityEngine velocityEngine) {
        super(mailerService, velocityEngine);
    }
    
}
