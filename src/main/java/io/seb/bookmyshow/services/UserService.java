package io.seb.bookmyshow.services;

import io.seb.bookmyshow.models.User;
import io.seb.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name, String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        User savedUser = null;

        if(optionalUser.isPresent()) {
            // move to the login workflow

        } else {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            savedUser = userRepository.save(user);
        }

        return savedUser;
    }

}
