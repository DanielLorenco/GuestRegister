package guestRegister.service;

import guestRegister.dto.UserDTO;
import guestRegister.entity.UserEntity;
import guestRegister.entity.repository.UserRepository;
import guestRegister.service.exceptions.DuplicateEmailException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService extends UserDetailsService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserDTO create(UserDTO model) {
        try {
            UserEntity entity = new UserEntity();
            entity.setEmail(model.getEmail());
            entity.setPassword(passwordEncoder.encode(model.getPassword()));
            entity = userRepository.save(entity);

            UserDTO dto = new UserDTO();
            dto.setUserId(entity.getUserId());
            dto.setEmail(entity.getEmail());
            return dto;
        } catch (DataIntegrityViolationException e) {
throw new DuplicateEmailException();
        }
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found." ));
    }


}
