package uk.co.andrewmaddock.wedding.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.service.PlayListService;

/**
 * Play List MVC Controller.
 *
 * @author Andrew Maddock
 *         Date: 11/07/13 16:48
 */
@Controller
@SessionAttributes("playList")
@RequestMapping(value = "/playlist")
public class PlayListController {

    private final PlayListService playListService;

    @Autowired
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute(new PlayList());
        return "playlist/playlist";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid PlayList playList, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "playlist/playlist";
        } else {
            playListService.save(playList);
            playListService.email(playList);
            status.setComplete();
            return "redirect:/playlist/confirm";    
        }
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm() {
        return "playlist/playlistConfirm";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view() {
        return "playlist/playlistView";
    }

}
