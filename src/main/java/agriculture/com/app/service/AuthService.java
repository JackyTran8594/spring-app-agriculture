package agriculture.com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import agriculture.com.app.repositories.UserRepository;

@Service
@Component
public class AuthService {
    @Autowired
    private UserRepository userRepository;

}
