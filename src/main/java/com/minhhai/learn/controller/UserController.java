package com.minhhai.learn.controller;

import com.minhhai.learn.entities.RoleEntity;
import com.minhhai.learn.entities.UserEntity;
import com.minhhai.learn.repository.RoleRepository;
import com.minhhai.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping()
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/message/{text}")
    public String hello(@PathVariable String text) {
        return "Hello anonymus user!";
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PostMapping("/role/create")
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleRepository.save(role);
    }

    @GetMapping("/user/{username}")
    public UserEntity getUser(@PathVariable String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityExistsException("User " + username + " doesn't exist in database"));
    }

    @GetMapping("/current")
    public UserEntity getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityExistsException("Wrong username " + username + " in SecurityContexHolder"));
    }

    @GetMapping("/token")
    public String checkRefreshToken() {
        return "Compare old and new token";
    }

    //test
    @GetMapping("/demo/find")
    public String find() {
        return "Compare old and new token";
    }

    @GetMapping("/test/find")
    public String test() {
        return "Compare old and new token";
    }

    @GetMapping("/search/find")
    public String search() {
        return "Compare old and new token";
    }
    @GetMapping("/admin/find")
    public String admin() {
        return "Compare old and new token";
    }

}
