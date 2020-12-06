/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Users Controller for dashboard and tabs for users (admin role users can also ping these pages)>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.RegistrationForm;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.services.MessageService;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UsersController {

    private final UserService userService;
    private final MessageService messageService;

    @ModelAttribute("messageForm")
    public Message messageForm() {
        return new Message();
    }

    public UsersController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }


    @GetMapping({"dashboard", "index"})
    public String dashboard(Model model ){
        model.addAttribute("users", userService.findAll());
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
    public String inbox(Model model){
        model.addAttribute("messages", messageService.findAll());
        return "users/inbox";

    }

    @GetMapping(path = "delete/{id}")
    public String deleteMessage(@PathVariable("id") long id) {
        messageService.deleteById(id);
        return "users/inbox";
    }

    @GetMapping(path = "read/{id}")
    public String readMessage(@PathVariable("id") long id, Model model) {
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "users/readMessage";
    }

    @GetMapping({"support", "support.html"})
    public String support(Message message){
        return "users/support";
    }

    @PostMapping("add")
    public String addMessage(@Valid Message messageForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "users/support";
        }

        messageService.save(messageForm);
        return "redirect:dashboard";
    }
}
