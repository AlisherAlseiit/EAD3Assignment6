package org.example.controller;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getALLUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {

        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }

    @PatchMapping("/{id}")
    public User updateUserAge(@PathVariable Long id,
                              @RequestParam String password) {
        User user = userRepository.findById(id).get();
        user.setPassword(password);

        return userRepository.saveAndFlush(user);
    }
}
