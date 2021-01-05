package agriculture.com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.User;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long> {

    // User findbyEmail(String email, String password);

    // User findbyUserName(String userName, String password);

    User findByUsername(String username);
}