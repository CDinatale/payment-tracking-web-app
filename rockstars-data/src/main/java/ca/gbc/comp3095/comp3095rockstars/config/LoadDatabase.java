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
        User bilbo = new User("Bilbo", "Baggins", "admin@isp.net", passwordEncoder.encode("password1"), "ADMIN");
        User admin = new User("Frodo", "Baggins", "frodo.baggins@gmail.com", passwordEncoder.encode("password2"), "USER");

        List<User> users = Arrays.asList(bilbo,admin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
