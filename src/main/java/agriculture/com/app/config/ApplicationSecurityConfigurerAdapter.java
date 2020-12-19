package agriculture.com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class ApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    // init configure
    // @Override
    // public void init(WebSecurity web) throws Exception {
    // // TODO Auto-generated method stub
    // // super.init(web);
    // web.ignoring().antMatchers("/resources/**");
    // }
    // // end

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // // TODO Auto-generated method stub
    // // super.configure(http);
    // http.authorizeRequests().antMatchers("/register").permitAll().antMatchers("/welcome").hasAnyRole("Admin")
    // .antMatchers("/user").authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
    // .permitAll()
    // .and()
    // .oauth2ResourceServer()
    // .jwt();

    // http.csrf().disable();
    // }
}
