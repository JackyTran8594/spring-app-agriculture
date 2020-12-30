package agriculture.com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import agriculture.com.app.filter.CustomSecurityFilter;
import agriculture.com.app.provider.CustomAuthenticationProvider;

@Configuration()
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class ApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomAuthenticationProvider authProvider;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub

    http.authorizeRequests().anyRequest().authenticated()
    // antMatchers("/api/oauth/token/**").permitAll().and().authorizeRequests()
    // .antMatchers("/api/register/**").permitAll().and().authorizeRequests().antMatchers("/api/user/**")
    // .authenticated()
    // .authenticated().and()
    // .oauth2ResourceServer()
    // .jwt();
    // => error in this: not found
    // class beartoken
    ;

    // http.oauth2Login();

    http.addFilterAfter(new CustomSecurityFilter(), BasicAuthenticationFilter.class);

    http.csrf().disable();
  }

}
