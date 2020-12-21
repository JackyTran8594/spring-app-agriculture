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

import agriculture.com.app.filter.CustomFilter;
import agriculture.com.app.provider.CustomAuthenticationProvider;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomAuthenticationProvider authProvider;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authProvider);
  }

  // init configure
  @Override
  public void init(WebSecurity web) throws Exception {
    // TODO Auto-generated method stub
    web.ignoring().antMatchers("/resources/**");
  }
  // // end

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub

    http.authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll()
        // .antMatchers("/register").permitAll().antMatchers("/welcome").hasAnyRole("Admin")
        // .antMatchers("/user").authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
        .anyRequest().permitAll()
        // .and().oauth2ResourceServer().jwt()
        ;
    // http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);

    http.csrf().disable();
  }

  // @Bean
  //  public AuthenticationManager authenticationManagerBean() throws Exception {
  //     return super.authenticationManagerBean();
  //  }
  // @Bean
  // public FilterRegistrationBean corsFilter() {
  //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  //     CorsConfiguration config = new CorsConfiguration();
  //     config.setAllowCredentials(true);
  //     config.addAllowedOrigin("*");
  //     config.addAllowedHeader("*");
  //     config.addAllowedMethod("*");
  //     source.registerCorsConfiguration("/**", config);
  //     FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
  //     bean.setOrder(0);
  //     return bean;
  // }
}
