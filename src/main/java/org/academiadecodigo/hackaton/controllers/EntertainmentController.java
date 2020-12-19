package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;
import org.academiadecodigo.hackaton.persistence.model.entertainment.EntertainmentType;
import org.academiadecodigo.hackaton.services.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/entertainment")
public class EntertainmentController {

    private EntertainmentService entertainmentService;

    @Autowired
    public void setEntertainmentService(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showEntertainment(@PathVariable Integer id, Model model) {

        Entertainment entertainment = entertainmentService.get(id);
        model.addAttribute("entertainment", entertainment);
        return "entertainment/show";
    }

    /*
    @RequestMapping(method = RequestMethod.GET, path = {"/list/restaurant"})
    public String listRestaurant(Model model) {
        model.addAttribute("entertainments", entertainmentService.listByType(EntertainmentType.RESTAURANT));
        return "entertainment/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list/culture"})
    public String listTransport(Model model) {
        model.addAttribute("entertainments", entertainmentService.listByType(EntertainmentType.TRANSPORT));
        return "entertainment/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list/nature"})
    public String listPosDate(Model model) {
        model.addAttribute("entertainments", entertainmentService.listByType(EntertainmentType.POS_DATE));
        return "entertainments/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list/services"})
    public String listPreDate(Model model) {
        model.addAttribute("entertainments", entertainmentService.listByType(EntertainmentType.PRE_DATE));
        return "entertainments/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list/crazy"})
    public String listCrazy(Model model) {
        model.addAttribute("entertainments", entertainmentService.listByType(EntertainmentType.CRAZY));
        return "entertainments/list";
    }*/

}
