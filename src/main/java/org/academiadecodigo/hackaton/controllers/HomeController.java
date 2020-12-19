package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.persistence.model.User;
import org.academiadecodigo.hackaton.persistence.model.entertainment.EntertainmentType;
import org.academiadecodigo.hackaton.services.AuthService;
import org.academiadecodigo.hackaton.services.EntertainmentService;
import org.academiadecodigo.hackaton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {

    private AuthService authService;
    private UserService userService;
    private EntertainmentService entertainmentService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setEntertainmentService(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/main"})
    public String main(Model model) {
        model.addAttribute(authService.getAccessingUser());
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String home() {
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/about"})
    public String aboutUs(Model model) {
        return "about-us";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/allPartners"})
    public String allPartners(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute("entertainments", entertainmentService.list());
            model.addAttribute(authService.getAccessingUser());
            return "allPartners";
        }
        return "redirect:/home";
    }
}
