package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.CategoryDTO;

import agriculture.com.app.model.Category;

import agriculture.com.app.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<Category> findAll() {

        var it = repository.findAll();

        var items = new ArrayList<Category>();
        it.forEach(e -> items.add(e));

        return items;
    }

    public Category getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = repository.findById(_id);
        Category item = exist.get();
        return item;
    }

    public void postRole(CategoryDTO categoryDTO) {
        Category item = oMapper.convertValue(categoryDTO, Category.class);
        repository.save(item);
    }

    public void updateRole(CategoryDTO categoryDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = repository.findById(uid).get();
        exist = oMapper.convertValue(categoryDTO, Category.class);
        repository.save(exist);
    }

    public Long count() {

        return repository.count();
    }

    public void deleteById(Long RoleId) {

        repository.deleteById(RoleId);
    }
}
