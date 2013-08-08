package uk.co.andrewmaddock.wedding.service.email.gae;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.service.email.MailerService;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * RsvpEmailServiceGae Test.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 15:43
 */
@RunWith(MockitoJUnitRunner.class)
public class RsvpEmailServiceGaeTest {

    private static final String NAMES = "Names";
    private static final boolean ATTENDING = true;
    private static final int ADULTS = 2;
    private static final int CHILDREN = 2;
    private static final boolean TRANSPORT = true;
    private static final String MESSAGE = "Message";
    private static final String TEMPLATE_LOCATION = "template";
    private static final String HTML_BODY = "body";

    @Spy
    @InjectMocks
    private final RsvpEmailServiceGae service = null;

    @Mock
    private MailerService mailerService = null;

    @Mock
    private VelocityEngine velocityEngine = null;
    
    @Mock
    private Rsvp rsvp = null;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        givenPlayListIs(NAMES, ATTENDING, ADULTS, CHILDREN, TRANSPORT, MESSAGE);
    }

    @Test
    public void noTemplateAndSendToAdminsIsFalseEmailThrowsUnsupportedOperationException() {
        givenTemplateLocationIs(null);
        givenSendToAdminsIs(false);

        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage(format(
                "%s does not support sending emails to recipients",
                service.getClass().getCanonicalName()
        ));

        service.email(rsvp);
    }

    @Test
    public void hasTemplateAndSendToAdminsIsFalseEmailThrowsUnsupportedOperationException() {
        givenTemplateLocationIs(TEMPLATE_LOCATION);
        givenSendToAdminsIs(false);

        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage(format(
                "%s does not support sending emails to recipients",
                service.getClass().getCanonicalName()
        ));

        service.email(rsvp);
    }

    @Test
    public void noTemplateAndSendToAdminsIsTrueEmailCallsMailServiceSendToAdmins() {
        givenTemplateLocationIs(null);
        givenSendToAdminsIs(true);

        service.email(rsvp);

        verify(mailerService).sendToAdmins(rsvp.getClass().getSimpleName(), expectedEmailBodyIs());
    }

    @Test
    public void hasTemplateAndSendToAdminsIsTrueEmailCallsMailServiceSendHtmlToAdmins() {
        givenTemplateLocationIs(TEMPLATE_LOCATION);
        givenSendToAdminsIs(true);
        givenHtmlBodyIs(HTML_BODY);

        service.email(rsvp);

        verify(mailerService).sendHtmlToAdmins(rsvp.getClass().getSimpleName(), HTML_BODY);
    }
    
    @Test
    public void emailRecipientThrowsUnsupportedOperationException() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage(format(
                "%s does not support sending emails to recipients",
                service.getClass().getCanonicalName()
        ));

        service.emailRecipient(rsvp);
    }

    @Test
    public void emailBodyReturnsPlayListItemAsString() {
        String emailBody = service.emailBody(rsvp);

        assertThat(emailBody, is(expectedEmailBodyIs()));
    }

    private void givenPlayListIs(String names, boolean attending, int adults, int children, boolean transport, String message) {
        when(rsvp.getNames()).thenReturn(names);
        when(rsvp.isAttending()).thenReturn(attending);
        when(rsvp.getAdults()).thenReturn(adults);
        when(rsvp.getChildren()).thenReturn(children);
        when(rsvp.isTransport()).thenReturn(transport);
        when(rsvp.getMessage()).thenReturn(message);
    }

    private void givenSendToAdminsIs(boolean sendToAdmins) {
        service.setSendToAdmins(sendToAdmins);
    }

    private void givenTemplateLocationIs(String templateLocation) {
        service.setTemplateLocation(templateLocation);
    }

    private String expectedEmailBodyIs() {
        final String newLine = System.getProperty("line.separator");
        return  "RSVP" + newLine + newLine +
                "Names: " + rsvp.getNames() + newLine +
                "Attending: " + rsvp.isAttending() + newLine +
                "Adults: " + rsvp.getAdults() + newLine +
                "Children: " + rsvp.getChildren() + newLine +
                "Transport: " + rsvp.isTransport() + newLine +
                "Message: " + rsvp.getMessage() + newLine;
    }

    private void givenHtmlBodyIs(String htmlBody) {
        doReturn(htmlBody).when(service).htmlBody(any(ModelMap.class));
    }
    
}
