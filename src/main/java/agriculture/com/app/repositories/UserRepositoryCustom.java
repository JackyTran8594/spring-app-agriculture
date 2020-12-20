package agriculture.com.app.repositories;

import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import agriculture.com.app.model.User;

public interface UserRepositoryCustom extends QuerydslPredicateExecutor<User> {

    User findbyEmail(String email, String password);
    
    User findbyUserName(String userName, String password);
}
