package agriculture.com.app.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        // if (name.equals("admin") && password.equals("system")) {
        //     final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        //     grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        //     final UserDetails principal = new User(name, password, grantedAuths);
        //     final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
        //     return auth;
        // } else {
        //     return null;
        // }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
