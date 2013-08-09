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
import uk.co.andrewmaddock.wedding.model.Rsvp;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * RsvpRepositoryGae Test.
 *
 * @author Andrew Maddock
 *         Date: 05/08/13 14:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application-config.xml", "classpath:spring/datasource-config.xml", })
@ActiveProfiles("gae")
public class RsvpRepositoryGaeTest {

    private static final String NAMES = "Names";
    private static final boolean ATTENDING = true;
    private static final int ADULTS = 2;
    private static final int CHILDREN = 2;
    private static final boolean TRANSPORT = true;
    private static final String MESSAGE = "Message";

    @Autowired
    private RsvpRepositoryGae repository = null;

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
    public void whenAttendingSaveDomainObject() {
        Rsvp rsvp = givenRsvpIs(NAMES, ATTENDING, ADULTS, CHILDREN, TRANSPORT, MESSAGE);

        repository.save(rsvp);

        assertThat(ofy().load().type(Rsvp.class).count(), is(1));
        assertThat(ofy().load().type(Rsvp.class).id(rsvp.getId()).now(), is(rsvp));
        
        Rsvp entity = ofy().load().entity(rsvp).now();
        assertThat(entity, is(rsvp));
        assertRsvp(entity, NAMES, ATTENDING, ADULTS, CHILDREN, TRANSPORT, MESSAGE);
    }
    
    @Test
    public void whenNotAttendingSaveDomainObjectClearsAdultsChildrenAndTransportFields() {
        Rsvp rsvp = givenRsvpIs(NAMES, false, ADULTS, CHILDREN, TRANSPORT, MESSAGE);

        repository.save(rsvp);

        assertThat(ofy().load().type(Rsvp.class).count(), is(1));
        assertThat(ofy().load().type(Rsvp.class).id(rsvp.getId()).now(), is(rsvp));
        
        Rsvp entity = ofy().load().entity(rsvp).now();
        assertThat(entity, is(rsvp));
        assertRsvp(entity, NAMES, false, 0, 0, false, MESSAGE);
    }

    private Rsvp givenRsvpIs(String names, boolean attending, int adults, int children, boolean transport, String message) {
        Rsvp rsvp = new Rsvp();
        rsvp.setNames(names);
        rsvp.setAttending(attending);
        rsvp.setAdults(adults);
        rsvp.setChildren(children);
        rsvp.setTransport(transport);
        rsvp.setMessage(message);
        return rsvp;
    }
    
    private void assertRsvp(Rsvp rsvp, String names, boolean attending, int adults, int children, boolean transport, String message) {
        assertThat(rsvp.getId(), notNullValue());
        assertThat(rsvp.getNames(), is(names));
        assertThat(rsvp.isAttending(), is(attending));
        assertThat(rsvp.getAdults(), is(adults));
        assertThat(rsvp.getChildren(), is(children));
        assertThat(rsvp.isTransport(), is(transport));
        assertThat(rsvp.getMessage(), is(message));    
    }
    
}
