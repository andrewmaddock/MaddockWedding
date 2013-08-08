package uk.co.andrewmaddock.wedding.service.email.gae;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.appengine.api.mail.MailService;
import uk.co.andrewmaddock.wedding.service.ServiceException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

/**
 * MailerServiceGae Test.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 15:23
 */
@RunWith(MockitoJUnitRunner.class)
public class MailerServiceGaeTest {

    private static final String TO = "toEmail";
    private static final String SUBJECT = "subject";
    private static final String BODY = "body";

    @InjectMocks
    private final MailerServiceGae service = null;

    @Mock
    private MailService mailService = null;

    @Captor
    private ArgumentCaptor<MailService.Message> messageCaptor = null;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void sendCreatesMessageAndCallsMailService() throws IOException {
        service.send(TO, SUBJECT, BODY);

        verify(mailService).send(messageCaptor.capture());
        assertThat(messageCaptor.getValue().getSender(), is(MailerServiceGae.SENDER_EMAIL));
        assertThat(messageCaptor.getValue().getTo(), hasItems(TO));
        assertThat(messageCaptor.getValue().getSubject(), is(SUBJECT));
        assertThat(messageCaptor.getValue().getTextBody(), is(BODY));
        assertThat(messageCaptor.getValue().getHtmlBody(), nullValue());
    }

    @Test
    public void sendThrowsExceptionWillRethrowAsServiceException() throws IOException {
        doThrow(new IOException()).when(mailService).send(any(MailService.Message.class));

        expectedException.expect(ServiceException.class);

        service.send(TO, SUBJECT, BODY);
    }

    @Test
    public void sendHtmlCreatesMessageAndCallsMailService() throws IOException {
        service.sendHtml(TO, SUBJECT, BODY);

        verify(mailService).send(messageCaptor.capture());
        assertThat(messageCaptor.getValue().getSender(), is(MailerServiceGae.SENDER_EMAIL));
        assertThat(messageCaptor.getValue().getTo(), hasItems(TO));
        assertThat(messageCaptor.getValue().getSubject(), is(SUBJECT));
        assertThat(messageCaptor.getValue().getTextBody(), nullValue());
        assertThat(messageCaptor.getValue().getHtmlBody(), is(BODY));
    }

    @Test
    public void sendHtmlThrowsExceptionWillRethrowAsServiceException() throws IOException {
        doThrow(new IOException()).when(mailService).send(any(MailService.Message.class));

        expectedException.expect(ServiceException.class);

        service.sendHtml(TO, SUBJECT, BODY);
    }

    @Test
    public void sendToAdminsCreatesMessageAndCallsMailService() throws IOException {
        service.sendToAdmins(SUBJECT, BODY);

        verify(mailService).sendToAdmins(messageCaptor.capture());
        assertThat(messageCaptor.getValue().getSender(), is(MailerServiceGae.SENDER_EMAIL));
        assertThat(messageCaptor.getValue().getTo(), empty());
        assertThat(messageCaptor.getValue().getSubject(), is(SUBJECT));
        assertThat(messageCaptor.getValue().getTextBody(), is(BODY));
        assertThat(messageCaptor.getValue().getHtmlBody(), nullValue());
    }

    @Test
    public void sendToAdminsThrowsExceptionWillRethrowAsServiceException() throws IOException {
        doThrow(new IOException()).when(mailService).sendToAdmins(any(MailService.Message.class));

        expectedException.expect(ServiceException.class);

        service.sendToAdmins(SUBJECT, BODY);
    }


    @Test
    public void sendToAdminsHtmlCreatesMessageAndCallsMailService() throws IOException {
        service.sendHtmlToAdmins(SUBJECT, BODY);

        verify(mailService).sendToAdmins(messageCaptor.capture());
        assertThat(messageCaptor.getValue().getSender(), is(MailerServiceGae.SENDER_EMAIL));
        assertThat(messageCaptor.getValue().getTo(), empty());
        assertThat(messageCaptor.getValue().getSubject(), is(SUBJECT));
        assertThat(messageCaptor.getValue().getTextBody(), nullValue());
        assertThat(messageCaptor.getValue().getHtmlBody(), is(BODY));
    }

    @Test
    public void sendToAdminsHtmlThrowsExceptionWillRethrowAsServiceException() throws IOException {
        doThrow(new IOException()).when(mailService).sendToAdmins(any(MailService.Message.class));

        expectedException.expect(ServiceException.class);

        service.sendHtmlToAdmins(SUBJECT, BODY);
    }
    
}
