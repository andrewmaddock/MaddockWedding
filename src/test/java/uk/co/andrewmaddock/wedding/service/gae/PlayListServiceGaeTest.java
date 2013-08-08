package uk.co.andrewmaddock.wedding.service.gae;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.repository.PlayListRepository;
import uk.co.andrewmaddock.wedding.service.ServiceException;
import uk.co.andrewmaddock.wedding.service.email.EmailService;

import static org.mockito.Mockito.*;

/**
 * PlayListServiceGae Test.
 *
 * @author Andrew Maddock
 *         Date: 29/07/13 17:36
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayListServiceGaeTest {

    private static final String REQUESTER = "Requester";
    private static final String ARTIST = "Artist";
    private static final String TRACK = "Track";
    private static final String WHY = "Why";

    @InjectMocks
    private final PlayListServiceGae service = null;

    @Mock
    private PlayListRepository repository = null;
    
    @Mock
    private EmailService<PlayList> emailService = null;
    
    @Mock
    private PlayList playList = null;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() {
        givenPlayListIs(REQUESTER, ARTIST, TRACK, WHY);    
    }

    @Test
    public void saveCallsRepositorySaveMethod() {
        service.save(playList);

        verify(repository).save(playList);
    }

    @Test
    public void saveThrowsExceptionReThrowsServiceException() {
        doThrow(NullPointerException.class).when(repository).save(playList);

        expectedException.expect(ServiceException.class);
        
        service.save(playList);
    }

    @Test
    public void emailCallsRepositoryEmailMethod() {
        service.email(playList);

        verify(emailService).email(playList);
    }

    @Test
    public void emailThrowsExceptionReThrowsServiceException() {
        doThrow(NullPointerException.class).when(emailService).email(playList);

        expectedException.expect(ServiceException.class);
        
        service.email(playList);
    }

    private void givenPlayListIs(String requester, String artist, String track, String why) {
        when(playList.getRequester()).thenReturn(requester);
        when(playList.getArtist()).thenReturn(artist);
        when(playList.getTrack()).thenReturn(track);
        when(playList.getWhy()).thenReturn(why);
    }
    
}
