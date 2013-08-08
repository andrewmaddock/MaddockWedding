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

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.service.email.MailerService;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * PlayListEmailServiceGae Test.
 *
 * @author Andrew Maddock
 *         Date: 02/08/13 15:28
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayListEmailServiceGaeTest {

    private static final String REQUESTER = "Requester";
    private static final String ARTIST = "Artist";
    private static final String TRACK = "Track";
    private static final String WHY = "Why";
    private static final String TEMPLATE_LOCATION = "template";
    private static final String HTML_BODY = "body";

    @Spy
    @InjectMocks
    private final PlayListEmailServiceGae service = null;

    @Mock
    private MailerService mailerService = null;

    @Mock
    private VelocityEngine velocityEngine = null;
    
    @Mock
    private PlayList playList = null;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        givenPlayListIs(REQUESTER, ARTIST, TRACK, WHY);
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
        
        service.email(playList);
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

        service.email(playList);
    }

    @Test
    public void noTemplateAndSendToAdminsIsTrueEmailCallsMailServiceSendToAdmins() {
        givenTemplateLocationIs(null);
        givenSendToAdminsIs(true);

        service.email(playList);
        
        verify(mailerService).sendToAdmins(playList.getClass().getSimpleName(), expectedEmailBodyIs());
    }

    @Test
    public void hasTemplateAndSendToAdminsIsTrueEmailCallsMailServiceSendHtmlToAdmins() {
        givenTemplateLocationIs(TEMPLATE_LOCATION);
        givenSendToAdminsIs(true);
        givenHtmlBodyIs(HTML_BODY);

        service.email(playList);
        
        verify(mailerService).sendHtmlToAdmins(playList.getClass().getSimpleName(), HTML_BODY);
    }

    @Test
    public void emailRecipientThrowsUnsupportedOperationException() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage(format(
                "%s does not support sending emails to recipients",
                service.getClass().getCanonicalName()
        ));
        
        service.emailRecipient(playList);
    }

    @Test
    public void emailBodyReturnsPlayListItemAsString() {
        String emailBody = service.emailBody(playList);

        assertThat(emailBody, is(expectedEmailBodyIs()));
    }

    private void givenPlayListIs(String requester, String artist, String track, String why) {
        when(playList.getRequester()).thenReturn(requester);
        when(playList.getArtist()).thenReturn(artist);
        when(playList.getTrack()).thenReturn(track);
        when(playList.getWhy()).thenReturn(why);
    }

    private void givenSendToAdminsIs(boolean sendToAdmins) {
        service.setSendToAdmins(sendToAdmins);
    }

    private void givenTemplateLocationIs(String templateLocation) {
        service.setTemplateLocation(templateLocation);
    }
    
    private String expectedEmailBodyIs() {
        final String newLine = System.getProperty("line.separator");
        return  "Playlist Item" + newLine + newLine +
                "Requester: " + playList.getRequester() + newLine +
                "Artist: " + playList.getArtist() + newLine +
                "Track: " + playList.getTrack() + newLine +
                "Why: " + playList.getWhy() + newLine;
    }

    private void givenHtmlBodyIs(String htmlBody) {
        doReturn(htmlBody).when(service).htmlBody(any(ModelMap.class));
    }

}
