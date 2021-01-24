package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.PostCommentDTO;
import agriculture.com.app.model.PostComment;

import agriculture.com.app.repositories.PostCommentRepository;

@Service
public class PostCommentService {

    @Autowired
    private PostCommentRepository repository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<PostComment> findAll() {

        var it = repository.findAll();

        var Comments = new ArrayList<PostComment>();
        it.forEach(e -> Comments.add(e));

        return Comments;
    }

    public PostComment getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = repository.findById(_id);
        PostComment comment = exist.get();
        return comment;
    }

    public void post(PostCommentDTO postCommentDTO) {
        PostComment item = oMapper.convertValue(postCommentDTO, PostComment.class);
        repository.save(item);
    }

    public void update(PostCommentDTO postCommentDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = repository.findById(uid).get();
        exist = oMapper.convertValue(postCommentDTO, PostComment.class);
        repository.save(exist);
    }

    public Long count() {

        return repository.count();
    }

    public void deleteById(Long RoleId) {

        repository.deleteById(RoleId);
    }
}
