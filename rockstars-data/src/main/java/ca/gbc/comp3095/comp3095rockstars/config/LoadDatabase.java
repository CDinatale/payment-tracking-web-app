package ca.gbc.comp3095.comp3095rockstars.config;

import ca.gbc.comp3095.comp3095rockstars.model.Role;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/*@Configuration
public class LoadDatabase {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            //delete all
            repository.deleteAll();

            log.info("Preloading " + repository.save(new User("Bilbo", "Baggins", "admin@isp.net", passwordEncoder.encode("password1"), "ADMIN")));
            log.info("Preloading " + repository.save(new User("Frodo", "Baggins", "frodo.baggins@gmail.com", passwordEncoder.encode("password2"), "USER")));
        };
    }

}*/
@Service
public class LoadDatabase implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoadDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
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
