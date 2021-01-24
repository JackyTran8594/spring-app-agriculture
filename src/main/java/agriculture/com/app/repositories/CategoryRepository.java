package agriculture.com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.Category;

@Repository
@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Role findByRole(String name);

}