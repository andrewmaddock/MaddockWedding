package uk.co.andrewmaddock.wedding.repository.gae;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.repository.PlayListRepository;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * PlayListRepositoryGae Test.
 *
 * @author Andrew Maddock
 *         Date: 05/08/13 11:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application-config.xml", "classpath:spring/datasource-config.xml", })
@ActiveProfiles("gae")
public class PlayListRepositoryGaeTest {

    private static final String REQUESTER = "Requester";
    private static final String ARTIST = "Artist";
    private static final String TRACK = "Track";
    private static final String WHY = "Why";
    
    @Autowired
    private PlayListRepository repository = null;
    
    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void saveDomainObject() {
        PlayList playList = givenPlayListIs(REQUESTER, ARTIST, TRACK, WHY);
        
        repository.save(playList);

        assertThat(ofy().load().type(PlayList.class).count(), is(1));
        assertThat(ofy().load().type(PlayList.class).id(playList.getId()).now(), is(playList));

        PlayList entity = ofy().load().entity(playList).now();
        assertThat(entity, is(playList));
        assertPlayList(entity, REQUESTER, ARTIST, TRACK, WHY);
    }

    private PlayList givenPlayListIs(String requester, String artist, String track, String why) {
        PlayList playList = new PlayList();
        playList.setRequester(requester);
        playList.setArtist(artist);
        playList.setTrack(track);
        playList.setWhy(why);
        return playList;
    }

    private void assertPlayList(PlayList playList, String requester, String artist, String track, String why) {
        assertThat(playList.getId(), notNullValue());
        assertThat(playList.getRequester(), is(requester));
        assertThat(playList.getArtist(), is(artist));
        assertThat(playList.getTrack(), is(track));
        assertThat(playList.getWhy(), is(why));
    }
    
}
