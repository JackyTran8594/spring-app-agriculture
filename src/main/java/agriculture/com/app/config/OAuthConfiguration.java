package agriculture.com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import agriculture.com.app.service.OAuthCustomService;

// import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
// @EnableAuthorizationServer
public class OAuthConfiguration extends OAuth2ResourceServerAutoConfiguration {

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final OAuthCustomService OAuthCustomService;

    public OAuthConfiguration(AuthenticationManager authenticationManager, OAuthCustomService OAuthCustomService) {
        this.authenticationManager = authenticationManager;
        this.OAuthCustomService = OAuthCustomService;
    }



}
