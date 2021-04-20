package org.example.controller;

import io.swagger.annotations.Api;
import org.example.Service.impl.UserServiceImpl;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Controller class", description = "This class allows to interact with User object")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ADMINTRAINEE', 'USER')")
    public String hello() {
        return "Hello everyone!";
    }

    @PostMapping("/registration")
    public void registration(@RequestBody User user){
        Role role = roleRepository.findRole("USER");
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(Collections.singletonList(role));

        userService.createUser(newUser);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ADMINTRAINEE')")
    public List<User> getALLUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ADMINTRAINEE', 'USER')")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }



//    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public void createUserByUsernamePassword(@RequestBody User newuser) {
//        User user = new User();
//        user.setPassword(newuser.getPassword());
//        user.setUsername(newuser.getUsername());
//
//        userService.createUser(user);
//    }

//    @PatchMapping("/{id}")
//    public User updateUserAge(@PathVariable Long id,
//                              @RequestParam String password) {
//        User user = userRepository.findById(id).get();
//        user.setPassword(password);
//
//        return userRepository.saveAndFlush(user);
//    }
}
