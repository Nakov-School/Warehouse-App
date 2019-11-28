package me.tcpackfrequency.Warehouse.controller;

import me.tcpackfrequency.Warehouse.model.User;
import me.tcpackfrequency.Warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable int id) {
        for(User u : repository.findAll()){
            if(u.getUSER_ID() == id){
                return u;
            }
        }
        // make exception, figure out why it doesnt throw it?
        throw new UsernameNotFoundException("Username not found.");
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
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
