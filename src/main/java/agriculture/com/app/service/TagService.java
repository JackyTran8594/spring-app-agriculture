package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.TagDTO;
import agriculture.com.app.model.Tag;
import agriculture.com.app.repositories.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<Tag> findAll() {

        var it = repository.findAll();

        var items = new ArrayList<Tag>();
        it.forEach(e -> items.add(e));

        return items;
    }

    public Tag getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = repository.findById(_id);
        Tag item = exist.get();
        return item;
    }

    public void post(TagDTO tagDTO) {
        Tag item = oMapper.convertValue(tagDTO, Tag.class);
        repository.save(item);
    }

    public void update(TagDTO tagDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = repository.findById(uid).get();
        exist = oMapper.convertValue(tagDTO, Tag.class);
        repository.save(exist);
    }

    public Long count() {

        return repository.count();
    }

    public void deleteById(Long RoleId) {

        repository.deleteById(RoleId);
    }
}
