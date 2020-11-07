package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/public")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> allUsers(){
        return this.userRepository.findAll();
    }
}
