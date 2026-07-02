package com.elsilencio.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilitar CSRF (No es necesario para APIs que usan JWT o React)
            .csrf(csrf -> csrf.disable())
            
            // 2. Configurar el acceso a las rutas (Endpoints)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // La ruta de Login será libre
                .anyRequest()/*.authenticated()*/.permitAll() // Todo lo demás (habitaciones, pagos, etc.) requiere estar logueado
            )
            
            // 3. Autenticación básica para pruebas iniciales en Postman
            .httpBasic(httpBasic -> {});

        return http.build();
    }

    // 4. Configuración de CORS para que React no sea bloqueado
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // La URL de tu proyecto React
        config.addAllowedHeader("*");
        config.addAllowedMethod("*"); // Permite GET, POST, PUT, DELETE, etc.
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
