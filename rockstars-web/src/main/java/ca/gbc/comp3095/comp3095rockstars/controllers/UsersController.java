/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Users Controller for dashboard and tabs for users (admin role users can also ping these pages)>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.services.ProfileService;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("users")
public class UsersController {

    private final UserService userService;

    private final ProfileService profileService;

    public UsersController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }


    @ModelAttribute("profilesForm")
    public Profile profilesForm() {
        return new Profile();
    }

    @PostMapping("myProfile")
    public String submitProfile(@Valid Profile profilesForm){

        User user = userService.findByEmail(profilesForm.getEmail());

        profilesForm.setUserForeignKey(user);
        profilesForm.setShippingAddressDefault(profilesForm.getShippingAddress());
        profilesForm.setBillingAddressDefault(profilesForm.getBillingAddress());
        profilesForm.setDateCreated(LocalDate.now());

        profileService.save(profilesForm);

        return "users/dashboard";
    }

    @GetMapping({"dashboard", "index"})
    public String dashboard(){
        return "users/dashboard";
    }

    @GetMapping({"myProfile", "myProfile.html"})
    public String myProfile(){
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
