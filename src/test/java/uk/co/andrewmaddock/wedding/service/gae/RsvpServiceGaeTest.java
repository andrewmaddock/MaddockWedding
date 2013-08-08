package uk.co.andrewmaddock.wedding.service.gae;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.repository.RsvpRepository;
import uk.co.andrewmaddock.wedding.service.ServiceException;
import uk.co.andrewmaddock.wedding.service.email.EmailService;

import static org.mockito.Mockito.*;

/**
 * RsvpServiceGae Test.
 *
 * @author Andrew Maddock
 *         Date: 29/07/13 17:51
 */
@RunWith(MockitoJUnitRunner.class)
public class RsvpServiceGaeTest {
    
    private static final String NAMES = "Names";
    private static final boolean ATTENDING = true;
    private static final int ADULTS = 2;
    private static final int CHILDREN = 2;
    private static final boolean TRANSPORT = true;
    private static final String MESSAGE = "Message";
                                     
    @InjectMocks
    private final RsvpServiceGae service = null;

    @Mock
    private RsvpRepository repository = null;

    @Mock
    private EmailService<Rsvp> emailService = null;

    @Mock
    private Rsvp rsvp = null;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() {
        givenRsvpIs(NAMES, ATTENDING, ADULTS, CHILDREN, TRANSPORT, MESSAGE);
    }
    
    @Test
    public void saveCallsRepositorySaveMethod() {
        service.save(rsvp);

        verify(repository).save(rsvp);
    }

    @Test
    public void saveThrowsExceptionReThrowsServiceException() {
        doThrow(NullPointerException.class).when(repository).save(rsvp);

        expectedException.expect(ServiceException.class);
                                
        service.save(rsvp);
    }

    @Test
    public void emailCallsRepositoryEmailMethod() {
        service.email(rsvp);

        verify(emailService).email(rsvp);
    }

    @Test
    public void emailThrowsExceptionReThrowsServiceException() {
        doThrow(NullPointerException.class).when(emailService).email(rsvp);

        expectedException.expect(ServiceException.class);

        service.email(rsvp);
    }
    
    private void givenRsvpIs(String names, boolean attending, int adults, int children, boolean transport, String message) {
        when(rsvp.getNames()).thenReturn(names);
        when(rsvp.isAttending()).thenReturn(attending);
        when(rsvp.getAdults()).thenReturn(adults);
        when(rsvp.getChildren()).thenReturn(children);
        when(rsvp.isTransport()).thenReturn(transport);
        when(rsvp.getMessage()).thenReturn(message);
    }   
    
}
