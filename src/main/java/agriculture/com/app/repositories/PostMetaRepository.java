package agriculture.com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import agriculture.com.app.model.PostMeta;

@Repository
@Component
public interface PostMetaRepository extends JpaRepository<PostMeta, Long> {

    // Role findByRole(String name);

}