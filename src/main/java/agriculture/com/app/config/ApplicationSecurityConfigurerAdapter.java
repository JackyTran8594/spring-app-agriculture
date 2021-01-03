package agriculture.com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import agriculture.com.app.config.Jwt.AuthEntryPointJwt;
import agriculture.com.app.config.Jwt.AuthTokenFilter;
import agriculture.com.app.filter.CustomSecurityFilter;
import agriculture.com.app.service.UserServiceDetailsImpl;


@Configuration()
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserServiceDetailsImpl userServiceImp;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandlder;

  // @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	// 	auth.authenticationProvider(authenticationProvider());
  // }
  
  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
      return new AuthTokenFilter();
  }

  
  // @Bean
  //  public DaoAuthenticationProvider authenticationProvider() {
  //      DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
  //      provider.setPasswordEncoder(bCryptPasswordEncoder());
  //      provider.setUserDetailsService(userServiceImp);
  //      return provider;
  //  }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
     return new BCryptPasswordEncoder();
   }

   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
       return super.authenticationManagerBean();
   }



  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub

   http.exceptionHandling().authenticationEntryPoint(unauthorizedHandlder);

    ;

    // http.oauth2Login();

    http.addFilterAfter(new CustomSecurityFilter(), BasicAuthenticationFilter.class);

    http.csrf().disable();
  }

}
