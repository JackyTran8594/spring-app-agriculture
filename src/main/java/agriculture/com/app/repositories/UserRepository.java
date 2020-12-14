package agriculture.com.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import agriculture.com.app.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}