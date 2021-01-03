package agriculture.com.app.repositories;

import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.User;

@Repository
@Component
public interface UserRepositoryCustom {

    User findbyEmail(String email, String password);

    User findbyUserName(String userName, String password);
    
    User findbyUserName(String userName);

}
