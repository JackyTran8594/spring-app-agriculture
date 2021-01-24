package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.PostDTO;
import agriculture.com.app.model.Post;
import agriculture.com.app.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<Post> findAll() {

        var it = repository.findAll();

        var items = new ArrayList<Post>();
        it.forEach(e -> items.add(e));

        return items;
    }

    public Post getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = repository.findById(_id);
        Post item = exist.get();
        return item;
    }

    public void postRole(PostDTO postDTO) {
        Post item = oMapper.convertValue(postDTO, Post.class);
        repository.save(item);
    }

    public void updateRole(PostDTO postDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = repository.findById(uid).get();
        exist = oMapper.convertValue(postDTO, Post.class);
        repository.save(exist);
    }

    public Long count() {

        return repository.count();
    }

    public void deleteById(Long RoleId) {

        repository.deleteById(RoleId);
    }
}
