/** Project: < Comp3095 Rockstars Project >
        * Assignment: < assignment 3 >
        * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
        * Student Number: < 101181089, 100645103, 101117858, 101219847>
        * Date: 11/08/2020
        * Description: <Loads the database and inputs the first two Users into the database>*/


package ca.gbc.comp3095.comp3095rockstars.config;
import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import ca.gbc.comp3095.comp3095rockstars.repository.ProfileRepository;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadDatabase implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ProfileRepository profileRepository;

    public LoadDatabase(UserRepository userRepository , PasswordEncoder passwordEncoder, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.profileRepository = profileRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();
        this.profileRepository.deleteAll();

        // Crete users


        User bilbo = new User("Bilbo", "Baggins", "30 Stadium Rd","admin@isp.net", passwordEncoder.encode("P@ssword1"), "ADMIN");
        User admin = new User("Frodo", "Baggins", "30 Stadium Rd","frodo.baggins@gmail.com", passwordEncoder.encode("P@ssword2"), "USER");
        //Profile profile1 = new Profile("Toronto", "Ca","n2n3n4", "address ex 1", "addess ex 2", "def address 1", "def address 2", LocalDate.now(), bilbo);
        //Profile profile2 = new Profile("Toronto2", "ca","222222", "address ex 1", "addess ex 2", "def address 1", "def address 2", LocalDate.now(), admin);
        User a = new User("Frodo", "Baggins", "30 Stadium Rd","a@a.aa", passwordEncoder.encode("a"), "USER");

        List<User> users = Arrays.asList(bilbo,admin,a);
        //List<Profile> profiles = Arrays.asList(profile2);

        // Save to db
        this.userRepository.saveAll(users);
        //this.profileRepository.saveAll(profiles);

    }
}
