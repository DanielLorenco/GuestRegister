package guestRegister.Configuration;

import guestRegister.dto.mapper.GuestMapper;
import guestRegister.dto.mapper.RoomMapper;
import guestRegister.entity.repository.GuestRepository;
import guestRegister.entity.repository.RoomRepository;
import guestRegister.service.GuestService;
import guestRegister.service.RoomService;
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
    public GuestService guestService(GuestRepository guestRepository, GuestMapper guestMapper, RoomRepository roomRepository) {
        return new GuestService(guestRepository, guestMapper, roomRepository);
    }

    @Bean
    public RoomService roomService(RoomRepository roomRepository, RoomMapper roomMapper, GuestRepository guestRepository) {
        return new RoomService(roomRepository, guestRepository, roomMapper);
    }
}
