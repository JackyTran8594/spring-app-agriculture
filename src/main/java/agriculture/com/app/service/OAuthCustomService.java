package agriculture.com.app.service;

import java.util.function.Predicate;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import agriculture.com.app.model.User;
import agriculture.com.app.repositories.UserRepository;

@Service
@Component
public class OAuthCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // public UserDetails loadUserByUsername(String username) {
    // var exist = userRepository.findbyUserName(username);
    // if (exist == null) {
    // throw new UsernameNotFoundException(username);
    // }
    // return new MyUserPrincipal(exist);
    // }

    // public UserDetails loadUserByEmail(String email) {
    // var exist = userRepository.findbyEmail(email);
    // if (exist == null) {
    // throw new UsernameNotFoundException(email);
    // }
    // return new MyUserPrincipal(exist);
    // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User exist = userRepository.findByUsername(username);
        if (exist == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(exist);
    }

}
