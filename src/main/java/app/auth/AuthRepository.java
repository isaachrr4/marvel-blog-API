package app.auth;

import app.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsernameAndPassword(String username, String pw);

}
