package ca.gbc.comp3095.comp3095rockstars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {

    @RequestMapping({"", "/", "index.html"})
    public String index(){return "index";}

    @RequestMapping({"dashboard"})
    public String dashboard(){return "dashboard";}
}
