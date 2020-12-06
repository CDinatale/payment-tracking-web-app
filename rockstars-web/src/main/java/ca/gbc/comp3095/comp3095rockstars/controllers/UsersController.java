/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Users Controller for dashboard and tabs for users (admin role users can also ping these pages)>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.services.ProfileServiceImpl;
import ca.gbc.comp3095.comp3095rockstars.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserServiceImpl userService;
    private ProfileServiceImpl profileService;

    @GetMapping({"dashboard", "index"})
    public String dashboard(Model model ){

        model.addAttribute("users", userService.findAll());
        return "users/dashboard";
    }

    @GetMapping({"myProfile", "myProfile.html"})
    public String myProfile(Model model){
        model.addAttribute("users", profileService.findAll());
        return "users/myProfile";
    }

    @GetMapping({"creditProfile", "creditProfile.html"})
    public String creditProfile(){
        return "users/creditProfile";
    }

    @GetMapping({"inbox", "inbox.html"})
    public String inbox(){
        return "users/inbox";
    }

    @GetMapping({"support", "support.html"})
    public String support(){
        return "users/support";
    }
}
