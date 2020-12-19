package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.commands.UserDto;
import org.academiadecodigo.hackaton.converter.UserDtoToUser;
import org.academiadecodigo.hackaton.converter.UserToUserDto;
import org.academiadecodigo.hackaton.persistence.model.User;
import org.academiadecodigo.hackaton.services.AuthService;
import org.academiadecodigo.hackaton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private AuthService authService;
    private UserService userService;

    private UserToUserDto userToUserDto;
    private UserDtoToUser userDtoToUser;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show")
    public String showUser(Model model) {
        if(authService.loggedIn()) {
            UserDto userDto = userToUserDto.convert(authService.getAccessingUser());
            model.addAttribute("user", userDto);
            return "user/show";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/edit")
    public String editUser(Model model) {
        if(authService.loggedIn()) {
            UserDto userDto = userToUserDto.convert(authService.getAccessingUser());
            model.addAttribute("user", userDto);
            return "user/show-edit";
        }
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/edit/save", params = "action=save")
    public String editSave(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            return "user/show-edit";
        }

        User savedUser = userService.add(userDtoToUser.convert(userDto));

        authService.setAccessingUser(savedUser);
        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedUser.getName() + " ID: " + savedUser.getId());
        return "redirect:/home/main";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/edit/save", params = "action=cancel")
    public String editCancel() {
        return "redirect:/home/main";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addPacket")
    public String addPacote(Model model){
        return "";
    }
}
