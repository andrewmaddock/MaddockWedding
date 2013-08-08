package uk.co.andrewmaddock.wedding.service.email.gae;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.utils.SystemProperty;
import uk.co.andrewmaddock.wedding.service.ServiceException;
import uk.co.andrewmaddock.wedding.service.email.MailerService;

import static com.google.appengine.api.mail.MailService.Message;

/**
 * GAE implementation of the {@link uk.co.andrewmaddock.wedding.service.email.MailerService} interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:57
 */
@Service
public class MailerServiceGae implements MailerService {

    protected static final Logger LOG = LoggerFactory.getLogger(MailerServiceGae.class.getName());

    public static final String SENDER_EMAIL = "donotreply@" + SystemProperty.applicationId.get() + ".appspotmail.com";

    private final MailService mailService;

    @Override
    public void send(String to, String subject, String body) throws ServiceException {
        try {
            mailService.send(new Message(SENDER_EMAIL, to, subject, body));
        } catch (IOException e) {
            LOG.error("MailerServiceGae", "send", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendHtml(String to, String subject, String htmlBody) throws ServiceException {
        try {
            Message message = new Message(SENDER_EMAIL, to, subject, null);
            message.setHtmlBody(htmlBody);
            mailService.send(message);
        } catch (IOException e) {
            LOG.error("MailerServiceGae", "sendHtml", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendToAdmins(String subject, String body) throws ServiceException {
        try {
            mailService.sendToAdmins(new Message(SENDER_EMAIL, null, subject, body));
        } catch (IOException e) {
            LOG.error("MailerServiceGae", "sendToAdmins", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendHtmlToAdmins(String subject, String htmlBody) throws ServiceException {
        try {
            Message message = new Message(SENDER_EMAIL, null, subject, null);
            message.setHtmlBody(htmlBody);
            mailService.sendToAdmins(message);
        } catch (IOException e) {
            LOG.error("MailerServiceGae", "sendHtmlToAdmins", e);
            throw new ServiceException(e);
        }
    }

    @Autowired
    public MailerServiceGae(MailService mailService) {
        this.mailService = mailService;    
    }
    
}
