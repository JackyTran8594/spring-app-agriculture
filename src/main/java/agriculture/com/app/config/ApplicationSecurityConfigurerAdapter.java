package agriculture.com.app.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import agriculture.com.app.config.Jwt.AuthEntryPointJwt;
import agriculture.com.app.config.Jwt.AuthTokenFilter;
import agriculture.com.app.service.UserDetailsServiceImpl;

@Configuration()
@EnableWebSecurity
public class ApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImp;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandlder;

  // filter authentication with Jwt
  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // TODO Auto-generated method stub
    auth.userDetailsService(userDetailsServiceImp).passwordEncoder(passwordEncoder());

  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub

    // catching authentication error
    http.exceptionHandling().authenticationEntryPoint(unauthorizedHandlder);

    // create session policy => using stateless
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.authorizeRequests().antMatchers("/auth/token").permitAll().antMatchers("/auth/refreshToken").permitAll()
        .antMatchers("/api/user/**").permitAll()
        // access index of angular app in resources static
        .antMatchers("/*").permitAll().anyRequest().authenticated();
    ;

    // add filter for spring security
    http.addFilterAfter(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    http.csrf().disable();
  }

}
