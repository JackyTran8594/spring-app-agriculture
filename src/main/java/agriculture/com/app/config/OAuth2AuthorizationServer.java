package agriculture.com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

// import agriculture.com.app.service.OAuthCustomService;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    // private final OAuthCustomService OAuthCustomService;

    // public OAuth2AuthorizationServer(OAuthCustomService OAuthCustomService) {
    // this.OAuthCustomService = OAuthCustomService;
    // }

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Value("${app.agriculture.cliex`nt.id}")
    private String client_id;
    @Value("${app.agriculture.client.secrect}")
    private String client_secrect;
    @Value("${app.agriculture.jwtTokenSigning}")
    private String jwtTokenSigning;
    @Value("${app.agriculture.accessTokenValiditySeconds}")
    private int accessTokenValiditySeconds;
    @Value("${app.agriculture.refreshTokenValiditySeconds}")
    private int refreshTokenValiditySeconds;

    // config client detail services for user
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("agriculturePlatform")
                // .secret(passwordEncoder().encode("123456"))
                .secret("secret").authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .scopes("read", "write").authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT").autoApprove(true)
                .accessTokenValiditySeconds(100).refreshTokenValiditySeconds(500);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // endpoints.accessTokenConverter(accessTokenConverter()).userDetailsService(OAuthCustomService);
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter()).userDetailsService(userDetailsService);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
