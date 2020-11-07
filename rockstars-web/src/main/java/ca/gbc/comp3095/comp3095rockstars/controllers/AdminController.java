package ca.gbc.comp3095.comp3095rockstars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping({"dashboard", "index"})
    public String index(){
        return "admin/dashboard";
    }

    @GetMapping({"tab1", "tab1.html"})
    public String tab1(){
        return "admin/tab1";
    }

    @GetMapping({"tab2", "tab2.html"})
    public String tab2(){
        return "admin/tab2";
    }

    @GetMapping({"tab3", "tab3.html"})
    public String tab3(){
        return "admin/tab3";
    }

    @GetMapping({"tab4", "tab4.html"})
    public String tab4(){
        return "admin/tab4";
    }
}
