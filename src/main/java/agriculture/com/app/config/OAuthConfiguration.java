package agriculture.com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import agriculture.com.app.service.OAuthCustomService;

@Configuration
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final OAuthCustomService OAuthCustomService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public OAuthConfiguration(AuthenticationManager authenticationManager, OAuthCustomService OAuthCustomService,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.OAuthCustomService = OAuthCustomService;
        this.passwordEncoder = passwordEncoder;
    }

    private String client_id;
    private String client_secrect;
    private String jwtTokenSigning;
    private int accessTokenValiditySeconds;
    private int refreshTokenValiditySeconds;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(client_id).secret(client_secrect)
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                .refreshTokenValiditySeconds(refreshTokenValiditySeconds);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    }

}
