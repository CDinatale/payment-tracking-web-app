/** Project: < Comp3095 Rockstars Project >
        * Assignment: < assignment 3 >
        * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
        * Student Number: < 101181089, 100645103, 101117858, 101219847>
        * Date: 11/08/2020
        * Description: <Loads the database and inputs the first two Users into the database>*/


package ca.gbc.comp3095.comp3095rockstars.config;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LoadDatabase implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoadDatabase(UserRepository userRepository , PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User bilbo = new User("Bilbo", "Baggins", "30 Stadium Rd","admin@isp.net", passwordEncoder.encode("P@ssword1"), "ADMIN");
        User admin = new User("Frodo", "Baggins", "30 Stadium Rd","frodo.baggins@gmail.com", passwordEncoder.encode("P@ssword2"), "USER");

        List<User> users = Arrays.asList(bilbo,admin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
