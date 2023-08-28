package com.blog.dmr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permite todas as origens, você pode configurar um valor específico aqui
        config.addAllowedMethod("*"); // Permite todos os métodos (GET, POST, PUT, DELETE, etc.)
        config.addAllowedHeader("*"); // Permite todos os headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
