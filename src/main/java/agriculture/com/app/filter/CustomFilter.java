package agriculture.com.app.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


// @Component
public class CustomFilter extends UsernamePasswordAuthenticationFilter  {

    // private AuthenticationManager authenticationManager;

    // public void JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    //     this.authenticationManager = authenticationManager;

    //     setFilterProcessesUrl("/api/login"); 
    // }


    
    // @Override
    // public Authentication attemptAuthentication(HttpServletRequest req,
    //                                             HttpServletResponse res) throws AuthenticationException {
    //     try {
    //         User creds = new ObjectMapper()
    //                 .readValue(req.getInputStream(), User.class);

    //         return authenticationManager.authenticate(
    //                 new UsernamePasswordAuthenticationToken(
    //                         creds.getUsername(),
    //                         creds.getPassword(),
    //                         new ArrayList<>())
    //         );
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    // @Override
    // protected void successfulAuthentication(HttpServletRequest req,
    //                                         HttpServletResponse res,
    //                                         FilterChain chain,
    //                                         Authentication auth) throws IOException {
    //     String token = JWT.create()
    //             .withSubject(((User) auth.getPrincipal()).getUsername())
    //             .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
    //             .sign(Algorithm.HMAC512(SECRET.getBytes()));

    //     String body = ((User) auth.getPrincipal()).getUsername() + " " + token;

    //     res.getWriter().write(body);
    //     res.getWriter().flush();
    // }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        chain.doFilter(request, response);

    }
    
}
