package uk.co.andrewmaddock.wedding.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.service.RsvpService;

/**
 * RSVP MVC Controller.
 *
 * @author Andrew Maddock
 *         Date: 11/07/13 16:48
 */
@Controller
@SessionAttributes("rsvp")
@RequestMapping(value = "/rsvp")
public class RsvpController {

    private final RsvpService rsvpService;

    @Autowired
    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(method = RequestMethod.GET)  
    public String init(Model model) {
        Rsvp rsvp = new Rsvp();
        rsvp.setAttending(true);
        model.addAttribute(rsvp);
        return "rsvp/rsvp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Rsvp rsvp, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "rsvp/rsvp";
        } else {
            rsvpService.save(rsvp);
            rsvpService.email(rsvp);
            status.setComplete();
            return "redirect:/rsvp/confirm";
        }
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm() {
        return "rsvp/rsvpConfirm";
    }


    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view() {
        return "rsvp/rsvpView";
    }

}
