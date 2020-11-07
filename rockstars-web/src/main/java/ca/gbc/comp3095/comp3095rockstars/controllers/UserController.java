package ca.gbc.comp3095.comp3095rockstars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;

@RequestMapping
@Controller
public class UserController {

    UserService userService;

    //public UserController(UserService userService) {this.userService = userService;}

    @RequestMapping({"/index"})
    public String listUsers(){
        return "users/index";
    }
}
