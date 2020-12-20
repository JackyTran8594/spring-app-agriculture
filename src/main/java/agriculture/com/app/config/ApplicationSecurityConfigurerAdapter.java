package agriculture.com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



// @EnableWebSecurity
@Configuration
public class ApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication()
          .withUser("john").password("123").roles("ADMIN");
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
        http.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
                // .antMatchers("/register").permitAll().antMatchers("/welcome").hasAnyRole("Admin")
                // .antMatchers("/user").authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
                .anyRequest().permitAll().and().oauth2ResourceServer().jwt();

        http.csrf().disable();
    }
}
