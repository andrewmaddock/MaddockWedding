package uk.co.andrewmaddock.wedding.mvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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

/**
 * RsvpController Test.
 *
 * @author Andrew Maddock
 *         Date: 26/07/13 17:25
 */
@RunWith(MockitoJUnitRunner.class)
public class RsvpControllerTest {

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
    private SessionStatus status = null;

    @Captor
    private ArgumentCaptor<Rsvp> rsvpCaptor = null;

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

        String view = controller.add(rsvp, result, status);

        assertThat(view, is("rsvp/rsvp"));
    }

    @Test
    public void addWithoutErrorsCallsServiceAndSetStatusToCompleteAndReturnsRedirectToPlaylistConfirm() {
        givenHasErrorsIs(false);

        String view = controller.add(rsvp, result, status);

        verify(service).save(rsvp);
        verify(service).email(rsvp);
        verify(status).setComplete();
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

    private void givenHasErrorsIs(boolean errors) {
        when(result.hasErrors()).thenReturn(errors);
    }    

}
