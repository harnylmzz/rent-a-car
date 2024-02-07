package com.tobeto.rentacar.security;

import com.tobeto.rentacar.services.jwt.AuthService;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class for handling security-related settings in the Rent a Car system.
 * It includes configuration for JWT authentication, method-level security, and API documentation using Swagger.
 *
 * @author [Harun Yılmaz]
 **/

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    private final AuthService authService;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x ->
                        x.requestMatchers(
                                //user
                                "/api/v1/users/**",
                                //auth
                                "/api/v1/auths/**",
                                //review
                                "/api/review/**",
                                //brand
                                "/api/v1/brands/**",
                                //car
                                "/api/v1/cars/**",
                                //customer
                                "/api/v1/customers/**",
                                //employee
                                "/api/v1/employees/**",
                                //rental
                                "/api/v1/rentals/**",
                                //category
                                "/api/v1/categories/**",
                                //colors
                                "/api/v1/colors/**",
                                //fuel-type
                                "/api/v1/fuelTypes/**",
                                //comprehensive-insurance
                                "/api/v1/comprehensiveInsurances/**",
                                //corporate-customer
                                "/api/v1/corporateCustomers/**",
                                //individual-customer
                                "/api/v1/individualCustomers/**",
                                //insurance
                                "/api/v1/insurances/**",
                                //model
                                "/api/v1/models/**",
                                //images
                                "/api/v1/images/**",
                                //promotion
                                "/api/v1/promotions/**",
                                //stripe
                                "/public/stripe/**",
                                //reservation
                                "/api/v1/reservations/**",
                                //invoice
                                "/api/v1/invoices/**",
                                //traffic-insurance
                                "/api/v1/trafficInsurances/**",
                                //swagger
                                "/swagger-ui/**",
                                "/swagger-ui",
                                "/swagger-resources/**",
                                "/v3/api-docs/**").permitAll()
                )
                .authorizeHttpRequests(x ->
                        x.requestMatchers("/auth/user").authenticated()
                                .requestMatchers("/auth/admin").hasRole("ADMIN")
                )
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .cors(cors->cors.disable())
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();

    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("My REST API")
                        .description("Some custom description of API.")
                        .version("1.0").contact(new Contact().name("Sallo Szrajbman")
                                .email("www.baeldung.com").url("salloszraj@gmail.com"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }
}
