package ca.gbc.comp3095.comp3095rockstars.config;

import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Bilbo", "Baggins", "bilbo.baggins@gmail.com", "password1")));
            log.info("Preloading " + repository.save(new User("Frodo", "Baggins", "frodo.baggins@gmail.com", "password2")));
        };
    }

}
