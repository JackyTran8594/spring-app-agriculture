package agriculture.com.app.provider;

import javax.security.auth.message.AuthException;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import agriculture.com.app.dto.LogInDTO;
import agriculture.com.app.service.MyUserPrincipal;
import agriculture.com.app.service.OAuthCustomService;
import agriculture.com.app.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private OAuthCustomService oAuthCustomService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        return null;
    }

    public Authentication authenticate(Authentication authentication, LogInDTO logInDTO)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        UserDetails user = oAuthCustomService.loadUserByEmail(logInDTO.email, logInDTO.password);
        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
