package agriculture.com.app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import agriculture.com.app.model.User;
import agriculture.com.app.repositories.UserRepository;


@Service
@Component
public class UserServiceDetailsImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        var exist = userRepository.findbyUserName(username);
        if (exist == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(exist);
    }
    
}
