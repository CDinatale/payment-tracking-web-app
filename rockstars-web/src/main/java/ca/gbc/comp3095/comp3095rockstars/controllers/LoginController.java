package ca.gbc.comp3095.comp3095rockstars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/")
@Controller
public class LoginController {

    @GetMapping({"", "/", "index"})
    public String index(){return "index";}

    @PostMapping({"/users/dashboard"})
    public String dashboard(){

        return "/users/dashboard";
    }
}
