package uk.co.andrewmaddock.wedding.service.email;

import uk.co.andrewmaddock.wedding.service.ServiceException;

/**
 * Mailer service interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:56
 */
public interface MailerService {

    void send(String to, String subject, String body) throws ServiceException;
    
    void sendHtml(String to, String subject, String htmlBody) throws ServiceException;   
    
    void sendToAdmins(String subject, String body) throws ServiceException;
    
    void sendHtmlToAdmins(String subject, String htmlBody) throws ServiceException;

}
