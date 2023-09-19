package com.caito.config.security;

import com.caito.utils.enums.Permission;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Component
@EnableWebSecurity
public class HttpSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csfrConfig -> csfrConfig.disable())
            .sessionManagement(sessionManagemenConfig -> sessionManagemenConfig.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.POST,"/api/v1/auth/login").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/api/v1/products")
                            .hasAuthority(Permission.READ_ALL_PRODUCTS.name());
                    authConfig.requestMatchers(HttpMethod.POST, "/api/v1/products")
                            .hasAuthority(Permission.SAVE_ONE_PRODUCT.name());
                    authConfig.anyRequest().denyAll();
                });
        return http.build();
    }

}
