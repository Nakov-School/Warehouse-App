package me.tcpackfrequency.Warehouse.controller;

import me.tcpackfrequency.Warehouse.config.WebSecurityConfig;
import me.tcpackfrequency.Warehouse.model.User;
import me.tcpackfrequency.Warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    WebSecurityConfig securityConfig;

    @Autowired
    UserRepository repository;

    @GetMapping("/users/")
    public List<User> allUsers(){
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable int id) {

        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        user.setUSER_PASSWORD(securityConfig.passwordEncoder().encode(user.getUSER_PASSWORD()));
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUSER_ID()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id) {

        Optional<User> userOptional = repository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setUSER_ID(id);

        repository.save(user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
    }

}
