/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Users Controller for dashboard and tabs for users (admin role users can also ping these pages)>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipal;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipalDetailsService;
import ca.gbc.comp3095.comp3095rockstars.services.ProfileService;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {

    private final UserService userService;
    private final ProfileService profileService;
    //maybe?
    private final UserPrincipalDetailsService userPrincipal;

    public UsersController(UserService userService, ProfileService profileService, UserPrincipalDetailsService userPrincipal) {
        this.userService = userService;
        this.profileService = profileService;
        this.userPrincipal = userPrincipal;
    }


    @GetMapping({"dashboard", "index"})
    public String dashboard(Model model ){

        model.addAttribute("users", userService.findAll());
        return "users/dashboard";
    }

    @GetMapping({"myProfile", "myProfile.html"})
    public String myProfile(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("profiles", profileService.findAll());
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
