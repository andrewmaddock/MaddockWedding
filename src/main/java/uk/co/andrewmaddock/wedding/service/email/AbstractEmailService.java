package uk.co.andrewmaddock.wedding.service.email;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.ui.velocity.VelocityEngineUtils;

import uk.co.andrewmaddock.wedding.model.BaseEntity;
import uk.co.andrewmaddock.wedding.service.ServiceException;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Abstract email service.
 *
 * @author Andrew Maddock
 *         Date: 31/07/13 15:32
 */
public abstract class AbstractEmailService<T extends BaseEntity> implements EmailService<T> {

//    protected static final Logger LOG = LoggerFactory.getLogger(AbstractEmailService.class.getName());

    private static final String ENCODING = "UTF-8";
    
    private final MailerService mailerService;
    private final VelocityEngine velocityEngine;
    
    private String templateLocation = null;
    private boolean sendToAdmins = false;

    @Override
    public void email(T domainObject) throws ServiceException {
        sendEmail(domainObject);        
    }
    
    private void sendEmail(T domainObject) {
        // If there is a html template send a html email
        if (isBlank(templateLocation)) {
            sendAsPlainText(domainObject);
        } else {
            sendAsHtml(domainObject);
        }    
    }

    private void sendAsPlainText(T domainObject) {
        if (sendToAdmins) {
            sendAsPlainTextToAdmins(domainObject);
        } else {
            sendAsPlainTextToRecipient(domainObject);
        }
    }

    private void sendAsHtml(T domainObject) {
        if (sendToAdmins) {
            sendAsHtmlToAdmins(domainObject);
        } else {
            sendAsHtmlToRecipient(domainObject);
        }
    }

    private void sendAsPlainTextToRecipient(T domainObject) {
        mailerService.send(
                emailRecipient(domainObject),
                domainObject.getClass().getSimpleName(),
                emailBody(domainObject));
    }

    private void sendAsPlainTextToAdmins(T domainObject) {
        mailerService.sendToAdmins(
                domainObject.getClass().getSimpleName(),
                emailBody(domainObject));
    }

    private void sendAsHtmlToRecipient(T domainObject) {
        mailerService.sendHtml(
                emailRecipient(domainObject),
                domainObject.getClass().getSimpleName(),
                htmlBody(new ModelMap(domainObject)));
    }

    private void sendAsHtmlToAdmins(T domainObject) {
        mailerService.sendHtmlToAdmins(
                domainObject.getClass().getSimpleName(),
                htmlBody(new ModelMap(domainObject)));
    }

    public String htmlBody(Map<String, Object> model) {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, ENCODING, model);
    }
    
    public abstract String emailRecipient(T domainObject);                  
    
    public abstract String emailBody(T domainObject);

    @Autowired
    public AbstractEmailService(MailerService mailerService, VelocityEngine velocityEngine) {
        this.mailerService = mailerService;
        this.velocityEngine = velocityEngine;
    }

    public AbstractEmailService(MailerService mailerService, VelocityEngine velocityEngine, String templateLocation, boolean sendToAdmins) {
        this(mailerService, velocityEngine);
        this.templateLocation = templateLocation;
        this.sendToAdmins = sendToAdmins;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }

    public void setSendToAdmins(boolean sendToAdmins) {
        this.sendToAdmins = sendToAdmins;
    }

}

