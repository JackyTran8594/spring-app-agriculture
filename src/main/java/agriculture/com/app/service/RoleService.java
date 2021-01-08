package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.RoleDTO;
import agriculture.com.app.model.Role;
import agriculture.com.app.repositories.RoleRepository;

@Service
@Component
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<Role> findAll() {

        var it = roleRepository.findAll();

        var Roles = new ArrayList<Role>();
        it.forEach(e -> Roles.add(e));

        return Roles;
    }

    public Role getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = roleRepository.findById(_id);
        Role Role = exist.get();
        return Role;
    }

    public void postRole(RoleDTO RoleDTO) {
        Role Role = oMapper.convertValue(RoleDTO, Role.class);
        roleRepository.save(Role);
    }

    public void updateRole(RoleDTO RoleDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = roleRepository.findById(uid).get();
        exist = oMapper.convertValue(RoleDTO, Role.class);
        roleRepository.save(exist);
    }

    public Long count() {

        return roleRepository.count();
    }

    public void deleteById(Long RoleId) {

        roleRepository.deleteById(RoleId);
    }
}
