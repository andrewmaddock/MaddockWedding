package uk.co.andrewmaddock.wedding.mvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.service.PlayListService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * PlayListController Test.
 *
 * @author Andrew Maddock
 *         Date: 26/07/13 16:51
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayListControllerTest {
    
    @InjectMocks
    private final PlayListController controller = null;
    
    @Mock
    private PlayListService service = null;
    
    @Mock
    private WebDataBinder dataBinder = null;    
    
    @Mock
    private Model model = null;    
    
    @Mock
    private PlayList playList = null;    
    
    @Mock
    private BindingResult result = null;    
    
    @Mock
    private SessionStatus status = null;

    @Test
    public void setAllowedFieldsDisablesIdField() {
        controller.setAllowedFields(dataBinder);

        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void initAddsPlaylistObjectAttributeAndReturnsPlaylistView() {
        String view = controller.init(model);

        verify(model).addAttribute(any(PlayList.class));
        assertThat(view, is("playlist/playlist"));
    }

    @Test
    public void addWithErrorsReturnsPlaylistView() {
        givenHasErrorsIs(true);

        String view = controller.add(playList, result, status);

        assertThat(view, is("playlist/playlist"));
    }

    @Test
    public void addWithoutErrorsCallsServiceAndSetStatusToCompleteAndReturnsRedirectToPlaylistConfirm() {
        givenHasErrorsIs(false);

        String view = controller.add(playList, result, status);

        verify(service).save(playList);
        verify(service).email(playList);
        verify(status).setComplete();
        assertThat(view, is("redirect:/playlist/confirm"));
    }

    @Test
    public void confirmReturnsPlaylistConfirmView() {
        String view = controller.confirm();

        assertThat(view, is("playlist/playlistConfirm"));
    }
    
    @Test
    public void viewReturnsPlaylistViewView() {
        String view = controller.view();

        assertThat(view, is("playlist/playlistView"));
    }

    private void givenHasErrorsIs(boolean errors) {
        when(result.hasErrors()).thenReturn(errors);
    }

}
