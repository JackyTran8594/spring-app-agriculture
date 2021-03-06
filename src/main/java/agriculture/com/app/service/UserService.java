package agriculture.com.app.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import agriculture.com.app.dto.UserDTO;
import agriculture.com.app.model.User;
import agriculture.com.app.repositories.UserRepository;

@Service
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private ObjectMapper oMapper = new ObjectMapper();

    public List<User> findAll() {

        var it = userRepository.findAll();

        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }

    public User getById(String id) {
        Long _id = Long.parseLong(id);
        var exist = userRepository.findById(_id);
        User user = exist.get();
        return user;
    }

    public void postUser(UserDTO userDTO) {
        userDTO.password = encodedPassword(userDTO.password, 20);
        User user = oMapper.convertValue(userDTO, User.class);
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO, String id) {
        Long uid = Long.parseLong(id);
        var exist = userRepository.findById(uid).get();
        exist = oMapper.convertValue(userDTO, User.class);
        userRepository.save(exist);
    }

    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }

    private String encodedPassword(String password, int length) {
        BCryptPasswordEncoder BCryptPasswordEncoder = new BCryptPasswordEncoder(length, new SecureRandom());
        String encodedPassword = BCryptPasswordEncoder.encode(password);
        return encodedPassword;
    }

    // public User getUserByEmail(String email) {
    // var exist = userRepository.

    // }

}
