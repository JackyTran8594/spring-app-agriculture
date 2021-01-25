package agriculture.com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import agriculture.com.app.model.User;

public class MyUserPrincipal implements UserDetails {

    /**
    *
    */
    private static final long serialVersionUID = -156382109433939994L;
    private User user;

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        String role = this.user.getAuthorities();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    public String getAuthoritiesOfUserPrincipal() {
        return this.user.getAuthorities();
    }

    public Long getIdOfUserPrincipal() {
        return this.user.getId();
    }

    public String getEmailOfUserPrincipal() {
        return this.user.getEmail();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
