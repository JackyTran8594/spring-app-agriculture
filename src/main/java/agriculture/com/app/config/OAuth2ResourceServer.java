// package agriculture.com.app.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
// import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
// import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

// @Configuration
// @EnableResourceServer
// public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

//     private static final String RESOURCE_ID = "resource-server-rest-api";

//     @Override
//     public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//         resources.resourceId(RESOURCE_ID);
//     }

//     @Override
//     public void configure(HttpSecurity http) throws Exception {
//         // enable protection on all endpoints starting /api/ and all other endpoints can
//         // be accessed freely
//         http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
//     }
// }
