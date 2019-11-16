package info.keyal.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * Let’s come up with the security requirement that only allows users with ‘ADMIN’ role to delete a Customer.
 * How do you restrict the deleteCustomer method from the CustomerController class for the user with a ‘USER’ role?
 *
 * To implement this requirement, we will apply Spring Security’s method level security on the deleteCustomer method.
 * Spring’s method level security can be enabled using EnableGlobalMethodSecurity annotation.
 *
 * Add the following PreAuthorize annotation to the above deleteCustomer method.
 * * @PreAuthorize(“hasAuthority(‘ROLE_ADMIN’)”)
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
