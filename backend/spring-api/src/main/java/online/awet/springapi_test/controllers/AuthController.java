package online.awet.springapi_test.controllers;

import online.awet.springapi_test.conf.Routes;
import online.awet.springapi_test.entities.UserEntity;
import online.awet.springapi_test.exceptions.UserServiceException;
import online.awet.springapi_test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class AuthController {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserRepository userRepository;

    public AuthController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping(Routes.AUTH_USER)
    public ResponseEntity<?> user(@AuthenticationPrincipal UserDetails currentUser) {
        return ResponseEntity.ok().body(currentUser.getUsername());
    }

    @PostMapping(Routes.AUTH_REGISTER)
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        try {
            UserEntity userToSave = new UserEntity();
            userToSave.setUsername(user.getUsername());
            userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
            userToSave.setAuthorities(List.of(() -> "ROLE_USER"));

            return ResponseEntity.ok().body(userRepository.save(userToSave));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(Routes.AUTH_UNREGISTER)
    public ResponseEntity<?> unregister(@RequestBody UserEntity user) {
        try {

            if (user == null || user.getUsername().isBlank() || user.getPassword().isBlank()) {
                return ResponseEntity.badRequest().body("User has missing or incorrect data.");
            }

            userRepository.delete(user);
            return ResponseEntity.ok().body("User unregistered.");

        } catch (UserServiceException e) {
            return ResponseEntity.badRequest().body("User could not be unregistered.");
        }
    }

}
