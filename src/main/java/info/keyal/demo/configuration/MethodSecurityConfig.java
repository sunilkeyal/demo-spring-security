package info.keyal.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * This class defines method level security configuration
 * <p>
 * The prePostEnabled property enables Spring Security pre/post annotations
 * <p>
 * The implementation is inside CustomerController.java
 * <p>
 * Use @PreAuthorize("hasAuthority('ROLE_ADMIN')") and the user must have ROLE_ADMIN to perform that operation
 * </P>>
 * <p>
 * The above annotation is used in deleteCustomer method and only ROLE_ADMIN user can now delete a customer.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
