package agriculture.com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration()
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    // @Override
    // protected MethodSecurityExpressionHandler createExpressionHandler() {
    // DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler
    // = new DefaultMethodSecurityExpressionHandler();
    // defaultMethodSecurityExpressionHandler.setPermissionEvaluator(new
    // CustomPermissionEvaluator());
    // return defaultMethodSecurityExpressionHandler;
    // }
}
