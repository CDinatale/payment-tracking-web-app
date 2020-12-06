/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Admin controller that sends to admin dashboard and tabs for admin>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;
import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.services.MessageService;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {


    private final UserService userService;
    private final MessageService messageService;

    public AdminController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping({"dashboard", "index"})
    public String index(@ModelAttribute("registrationForm") @Valid User user, Model model){

        model.addAttribute("firstName", user.getFirstName());
        return "admin/dashboard";
    }

    @GetMapping({"myProfile", "myProfile.html"})
    public String myProfile(){
        return "admin/myProfile";
    }

    @GetMapping({"userListing", "userListing.html"})
    public String userListing(){
        return "admin/userListing";
    }

    @GetMapping({"inbox", "inbox.html"})
    public String inbox(Model model){
        model.addAttribute("messages", messageService.findAll());
        return "admin/inbox";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "admin/dashboard";
    }

    @GetMapping("remove/{id}")
    public String deleteMessage(@PathVariable("id") long id) {
        messageService.deleteById(id);
        return "admin/inbox";
    }

    @GetMapping({"support", "support.html"})
    public String support(Model model, User userForm){

        model.addAttribute("users", userService.findAll());
        model.addAttribute("userForm", userForm);
        return "admin/support";
    }

    @PostMapping("addAdmin")
    public String addMessage(@Valid User userForm, BindingResult result, Model model){

        User existing = userService.findByEmail(userForm.getEmail());
        if (existing != null) {
            result.rejectValue("email", "There is already an account registered with that email.");
            return "admin/support";
        }
        else {
            userForm.setRolesAdmin();
            userService.saveAdmin(userForm);
            return "redirect:dashboard";
        }
    }

}
