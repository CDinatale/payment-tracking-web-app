package ca.gbc.comp3095.comp3095rockstars.repository;

import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
