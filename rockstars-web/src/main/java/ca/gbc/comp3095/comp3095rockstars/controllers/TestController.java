/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 2 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, >
 * Date: 11/08/2020
 * Description: <Test Controller that is a rest controller that will print out the contents of the database for viewing access>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/public")
public class TestController {
    UserRepository userRepository;

    public TestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> allUsers(){
        return this.userRepository.findAll();
    }
}
