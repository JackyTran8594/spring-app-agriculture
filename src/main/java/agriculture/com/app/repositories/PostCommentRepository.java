package agriculture.com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.PostComment;

@Repository
@Component
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

    // PostComment findByPostComment(String name);

}