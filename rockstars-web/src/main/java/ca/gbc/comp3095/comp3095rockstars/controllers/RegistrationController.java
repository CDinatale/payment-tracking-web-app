package ca.gbc.comp3095.comp3095rockstars.controllers;


import ca.gbc.comp3095.comp3095rockstars.model.RegistrationForm;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    //autowire user repository
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path= "/registration")
    public String registration(){return "registration";}

    @PostMapping(path = "/registration")
    public String submitRegistration(RegistrationForm registrationForm){
        //check whether the form data is coming or not
        User user = null;
        if(null != registrationForm){
            user = new User(registrationForm.getFirstName(), registrationForm.getLastName(),
                    registrationForm.getEmailId(), registrationForm.getPassword());
        }
        userRepository.save(user);
        return "registration-success";
    }
/*
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }*/
}
