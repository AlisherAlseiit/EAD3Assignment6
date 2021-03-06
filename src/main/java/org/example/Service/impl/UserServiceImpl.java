package org.example.Service.impl;

import org.example.Service.UserService;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordConfig passwordEncoder;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void createUser(User user) {
        user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }


    public void updateUser(Long id, User user) {
        User userDb = userRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword()); // plaintext password

            userRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
        return user;
    }
}
