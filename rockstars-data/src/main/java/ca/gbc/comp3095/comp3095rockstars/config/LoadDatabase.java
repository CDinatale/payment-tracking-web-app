/** Project: < Comp3095 Rockstars Project >
        * Assignment: < assignment 3 >
        * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
        * Student Number: < 101181089, 100645103, 101117858, 101219847>
        * Date: 11/08/2020
        * Description: <Loads the database and inputs the first two Users into the database>*/


package ca.gbc.comp3095.comp3095rockstars.config;
import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.repository.MessageRepository;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LoadDatabase implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageRepository messageRepository;
    private final Date date;

    public LoadDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.messageRepository = messageRepository;

        this.date = new Date(2020);
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();
        this.messageRepository.deleteAll();


        // Crete users
        User admin = new User("Bilbo", "Baggins", "30 Stadium Rd","admin@isp.net", passwordEncoder.encode("P@ssword1"), "ADMIN");
        User user = new User("Frodo", "Baggins", "30 Stadium Rd","frodo.baggins@gmail.com", passwordEncoder.encode("P@ssword2"), "USER");
        //Message message1 = new Message("frodo", "bilbo", "unread", "I cannot find my password", "Password Problem", date);
        //Message message2 = new Message("bilbo", "uncle", "read", "I will help you find your password", "Password Problem Fixed", date);
        //message1.setUser(user);
        //message2.setUser(admin);
        List<User> users = Arrays.asList(admin,user);
        //List <Message> messages = Arrays.asList(message1, message2);


        // Save to db
        this.userRepository.saveAll(users);
        //this.messageRepository.saveAll(messages);
    }
}
