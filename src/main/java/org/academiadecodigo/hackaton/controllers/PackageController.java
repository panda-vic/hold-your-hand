package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;
import org.academiadecodigo.hackaton.services.AuthService;
import org.academiadecodigo.hackaton.services.EntertainmentService;
import org.academiadecodigo.hackaton.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/packages")
public class PackageController {

    private AuthService authService;
    private PackageService packageService;
    private EntertainmentService entertainmentService;

    @Autowired
    public void setPackageService(PackageService packageService) {
        this.packageService = packageService;
    }

    @Autowired
    public void setEntertainmentService(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public String showAllPackages(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "allPackages";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/create")
    public String createPackages(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "ownPack";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/build/done")
    public String buildPackages(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "buildDone";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/eco")
    public String showEcoPackage(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "EcoDate";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bankrupt")
    public String showBankruptPackage(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "BankruptDate";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/budget")
    public String showOnABudgetPackage(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "BudgetDate";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lisbon")
    public String showLisbonPackage(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "LisbonExperienceDate";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/covid")
    public String showCovidPackage(Model model) {
        if(authService.loggedIn()) {
             model.addAttribute(authService.getAccessingUser());
             return "CovidDate";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/drugs")
    public String showDrugsPackage(Model model) {
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "DrugDate";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addEntertainment(Model model){
        if(authService.loggedIn()) {
            model.addAttribute(authService.getAccessingUser());
            return "";
        }
        return "redirect:/home";
    }

}
