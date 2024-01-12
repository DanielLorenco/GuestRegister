package guestRegister.Configuration;

import guestRegister.dto.mapper.GuestMapper;
import guestRegister.entity.repository.GuestRepository;
import guestRegister.service.GuestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedOriginPatterns("**")
                .allowCredentials(true);
    }

    @Bean
    public GuestService guestService(GuestRepository guestRepository, GuestMapper guestMapper) {
        return new GuestService(guestRepository, guestMapper);
    }

}
