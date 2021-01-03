package agriculture.com.app.config.Jwt;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.Jwt;
import org.springframework.stereotype.Component;

import agriculture.com.app.service.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    
    private static final Logger LOGGER = LogManager.getLogger(JwtUtils.class);

    private String jwtSecret;

    private int jwtExpiration;

    public String generateJwtToken(Authentication authentication){
        
        UserDetailsImpl userPrincipal = (UserDetailsImpl)authentication.getPrincipal();
        return Jwts.builder()
        .setSubject((userPrincipal.getUsername()))
                                .setIssuedAt(new Date())
                                .setExpiration(new Date((new Date()).getTime()+ jwtExpiration))
                                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                                .compact();
                                
    }

}
