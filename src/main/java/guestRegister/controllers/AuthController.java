package guestRegister.controllers;

import guestRegister.dto.LoginRequest;
import guestRegister.dto.JwtResponse;
import guestRegister.security.JwtUtil;
import guestRegister.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(user);

        return new JwtResponse(token);
    }
}
