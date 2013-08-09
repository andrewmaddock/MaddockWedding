package uk.co.andrewmaddock.wedding.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.service.RsvpService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * RsvpController Test.
 *
 * @author Andrew Maddock
 *         Date: 26/07/13 17:25
 */
@RunWith(MockitoJUnitRunner.class)
public class RsvpControllerTest {

    private static final String NAMES = "Names";
    private static final boolean ATTENDING = true;
    private static final int ADULTS = 2;
    private static final int CHILDREN = 2;
    private static final boolean TRANSPORT = true;
    private static final String MESSAGE = "Message";
    
    @InjectMocks
    private final RsvpController controller = null;

    @Mock
    private RsvpService service = null;

    @Mock
    private WebDataBinder dataBinder = null;

    @Mock
    private Model model = null;

    @Mock
    private Rsvp rsvp = null;

    @Mock
    private BindingResult result = null;

    @Mock
    private SessionStatus sessionStatus = null;

    @Captor
    private ArgumentCaptor<Rsvp> rsvpCaptor = null;

    private MockMvc mockMvc = null;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void setAllowedFieldsDisablesIdField() {
        controller.setAllowedFields(dataBinder);

        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void initAddsPlaylistObjectAttributeAndReturnsPlaylistView() {
        String view = controller.init(model);

        verify(model).addAttribute(rsvpCaptor.capture());
        assertThat(rsvpCaptor.getValue().isAttending(), is(true));
        assertThat(view, is("rsvp/rsvp"));
    }

    @Test
    public void addWithErrorsReturnsPlaylistView() {
        givenHasErrorsIs(true);

        String view = controller.add(rsvp, result, sessionStatus);

        assertThat(view, is("rsvp/rsvp"));
    }

    @Test
    public void addWithoutErrorsCallsServiceAndSetStatusToCompleteAndReturnsRedirectToPlaylistConfirm() {
        givenHasErrorsIs(false);

        String view = controller.add(rsvp, result, sessionStatus);

        verify(service).save(rsvp);
        verify(service).email(rsvp);
        verify(sessionStatus).setComplete();
        assertThat(view, is("redirect:/rsvp/confirm"));
    }

    @Test
    public void confirmReturnsPlaylistConfirmView() {
        String view = controller.confirm();

        assertThat(view, is("rsvp/rsvpConfirm"));
    }

    @Test
    public void viewReturnsPlaylistViewView() {
        String view = controller.view();

        assertThat(view, is("rsvp/rsvpView"));
    }

    @Test
    public void mvcAddConfirm() throws Exception {
        Rsvp sessionRsvp = givenRsvpIs(NAMES, ATTENDING, ADULTS, CHILDREN, TRANSPORT, MESSAGE);

        mockMvc.perform(
                post("/rsvp")
                    .sessionAttr("rsvp", sessionRsvp))
                .andDo(print())
                .andExpect(status().isMovedTemporarily())
                .andExpect(model().hasNoErrors())
                .andExpect(redirectedUrl("/rsvp/confirm"));

        verify(service).save(sessionRsvp);
        verify(service).email(sessionRsvp);
    }

    @Test
    public void mvcAddErrors() throws Exception {
        mockMvc.perform(
                post("/rsvp")
                    .sessionAttr("rsvp", new Rsvp()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors())
                .andExpect(view().name("rsvp/rsvp"));
    }

    @Test
    public void mvcConfirm() throws Exception {
        mockMvc.perform(get("/rsvp/confirm"))
                .andExpect(status().isOk())
                .andExpect(model().size(0))
                .andExpect(view().name("rsvp/rsvpConfirm"));
    }

    private void givenHasErrorsIs(boolean errors) {
        when(result.hasErrors()).thenReturn(errors);
    }

    private Rsvp givenRsvpIs(String names, boolean attending, int adults, int children, boolean transport, String message) {
        Rsvp r = new Rsvp();
        r.setNames(names);
        r.setAttending(attending);
        r.setAdults(adults);
        r.setChildren(children);
        r.setTransport(transport);
        r.setMessage(message);
        return r;
    }

}
