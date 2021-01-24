package agriculture.com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.Post;
import agriculture.com.app.model.PostMeta;

@Repository
@Component
public interface PostRepository extends JpaRepository<Post, Long> {

    // Role findByRole(String name);

}