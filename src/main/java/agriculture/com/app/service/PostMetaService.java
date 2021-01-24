package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.PostMetaDTO;
import agriculture.com.app.model.PostMeta;
import agriculture.com.app.repositories.PostMetaRepository;

@Service
public class PostMetaService {

    @Autowired
    private PostMetaRepository repository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<PostMeta> findAll() {

        var it = repository.findAll();

        var items = new ArrayList<PostMeta>();
        it.forEach(e -> items.add(e));

        return items;
    }

    public PostMeta getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = repository.findById(_id);
        PostMeta item = exist.get();
        return item;
    }

    public void postRole(PostMetaDTO postMetaDTO) {
        PostMeta item = oMapper.convertValue(postMetaDTO, PostMeta.class);
        repository.save(item);
    }

    public void updateRole(PostMetaDTO postMetaDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = repository.findById(uid).get();
        exist = oMapper.convertValue(postMetaDTO, PostMeta.class);
        repository.save(exist);
    }

    public Long count() {

        return repository.count();
    }

    public void deleteById(Long RoleId) {

        repository.deleteById(RoleId);
    }
}
