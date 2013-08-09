package uk.co.andrewmaddock.wedding.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * PlayListController Test.
 *
 * @author Andrew Maddock
 *         Date: 26/07/13 16:51
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayListControllerTest {

    private static final String REQUESTER = "Requester";
    private static final String ARTIST = "Artist";
    private static final String TRACK = "Track";
    private static final String WHY = "Why";
    
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
    private SessionStatus sessionStatus = null;

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

        verify(model).addAttribute(any(PlayList.class));
        assertThat(view, is("playlist/playlist"));
    }

    @Test
    public void addWithErrorsReturnsPlaylistView() {
        givenHasErrorsIs(true);

        String view = controller.add(playList, result, sessionStatus);

        assertThat(view, is("playlist/playlist"));
    }

    @Test
    public void addWithoutErrorsCallsServiceAndSetStatusToCompleteAndReturnsRedirectToPlaylistConfirm() {
        givenHasErrorsIs(false);

        String view = controller.add(playList, result, sessionStatus);

        verify(service).save(playList);
        verify(service).email(playList);
        verify(sessionStatus).setComplete();
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

    @Test
    public void mvcInit() throws Exception {
        mockMvc.perform(
                get("/playlist"))
                    .andExpect(status().isOk())
                    .andExpect(model().size(1))
                    .andExpect(model().attributeExists("playList"))
                    .andExpect(view().name("playlist/playlist"));
    }

    @Test
    public void mvcAddConfirm() throws Exception {
        PlayList sessionPlayList = givenPlayListIs(REQUESTER, ARTIST, TRACK, WHY);
        
        mockMvc.perform(
                post("/playlist")
                    .sessionAttr("playList", sessionPlayList))
                .andDo(print())
                .andExpect(status().isMovedTemporarily())
                .andExpect(model().hasNoErrors())
                .andExpect(redirectedUrl("/playlist/confirm"));
        
        verify(service).save(sessionPlayList);
        verify(service).email(sessionPlayList);
    }

    @Test
    public void mvcAddErrors() throws Exception {
        mockMvc.perform(
                post("/playlist")
                    .sessionAttr("playList", new PlayList()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors())
                .andExpect(view().name("playlist/playlist"));
    }

    @Test
    public void mvcConfirm() throws Exception {
        mockMvc.perform(get("/playlist/confirm"))
                .andExpect(status().isOk())
                .andExpect(model().size(0))
                .andExpect(view().name("playlist/playlistConfirm"));
    }

    private void givenHasErrorsIs(boolean errors) {
        when(result.hasErrors()).thenReturn(errors);
    }

    private PlayList givenPlayListIs(String requester, String artist, String track, String why) {
        PlayList p = new PlayList(); 
        p.setRequester(requester);
        p.setArtist(artist);
        p.setTrack(track);
        p.setWhy(why);
        return p;
    }

}
