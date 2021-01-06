package agriculture.com.app.config.Jwt;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.Jwt;
import org.springframework.stereotype.Component;

import agriculture.com.app.model.User;
import agriculture.com.app.service.MyUserPrincipal;
import agriculture.com.app.service.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {

    private static final Logger LOGGER = LogManager.getLogger(JwtUtils.class);

    @Value("${app.agriculture.client.secrect}")
    private String jwtSecret;

    @Value("${app.agriculture.accessTokenValiditySeconds}")
    private int jwtExpiration;

    @Value("${app.agriculture.refreshTokenValiditySeconds}")
    private int jwtRefreshExpiration;

    public String generateJwtToken(Authentication authentication) {

        Object objectPrincipal = authentication.getPrincipal();
        // UserDetailsImpl userPrincipal = (UserDetailsImpl) objectPrincipal;
        MyUserPrincipal userPrincipal = (MyUserPrincipal) objectPrincipal;

        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

    }

    public String doGenerateRefreshJwtToken(Authentication authentication) {
        Object objectPrincipal = authentication.getPrincipal();
        MyUserPrincipal userPrincipal = (MyUserPrincipal) objectPrincipal;
        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtRefreshExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public boolean validateJwtToken(String authJwtToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authJwtToken);
            return true;

        } catch (SignatureException e) {
            // TODO: handle exception
            LOGGER.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public String getUserNameFromJwtToken(String jwtToken) {
        String tokenParser = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody().getSubject();
        return tokenParser;
    }

}
