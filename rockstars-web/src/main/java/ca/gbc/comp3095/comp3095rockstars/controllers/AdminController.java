/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Admin controller that sends to admin dashboard and tabs for admin>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping({"dashboard", "index"})
    public String index(@ModelAttribute("registrationForm") @Valid User user, Model model){

        model.addAttribute("firstName", user.getFirstName());
        return "admin/dashboard";
    }

    @GetMapping({"myProfile", "myProfile.html"})
    public String tab1(){
        return "admin/myProfile";
    }

    @GetMapping({"userListing", "userListing.html"})
    public String tab2(){
        return "admin/userListing";
    }

    @GetMapping({"inbox", "inbox.html"})
    public String tab3(){
        return "admin/inbox";
    }

    @GetMapping({"support", "support.html"})
    public String tab4(){
        return "admin/support";
    }
}
