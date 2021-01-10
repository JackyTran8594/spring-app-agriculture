package agriculture.com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.User;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}