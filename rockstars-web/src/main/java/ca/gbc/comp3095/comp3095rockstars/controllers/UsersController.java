/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 2 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, >
 * Date: 11/08/2020
 * Description: <Users Controller for dashboard and tabs for users (admin role users can also ping these pages)>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {
    @GetMapping({"dashboard", "index"})
    public String index(){
        return "users/dashboard";
    }

    @GetMapping({"tab1", "tab1.html"})
    public String tab1(){
        return "users/tab1";
    }

    @GetMapping({"tab2", "tab2.html"})
    public String tab2(){
        return "users/tab2";
    }

    @GetMapping({"tab3", "tab3.html"})
    public String tab3(){
        return "users/tab3";
    }

    @GetMapping({"tab4", "tab4.html"})
    public String tab4(){
        return "users/tab4";
    }
}
