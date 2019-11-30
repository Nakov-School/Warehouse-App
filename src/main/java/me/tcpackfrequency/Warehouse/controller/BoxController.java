package me.tcpackfrequency.Warehouse.controller;

import me.tcpackfrequency.Warehouse.model.Box;
import me.tcpackfrequency.Warehouse.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class BoxController {

    @Autowired
    BoxRepository repository;

    @GetMapping("/boxes/{id}")
    public Box getBox(@PathVariable int id){
       Optional<Box> box = repository.findById(id);
        if(box.isPresent()){
            return box.get();
        } else {
            // make new exceptions!!
            throw new UsernameNotFoundException("box not found");
        }
    }

    @GetMapping("/boxes")
    public List<Box> allBoxes(){
        return repository.findAll();
    }

    @PutMapping("/boxes/{id}")
    public ResponseEntity<Object> updateBox(@RequestBody Box box, @PathVariable int id) {
        Optional<Box> boxOptional = repository.findById(id);
        if (!boxOptional.isPresent())
            return ResponseEntity.notFound().build();
        box.setId(id);
        repository.save(box);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/boxes/{id}")
    public void deleteBox(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PostMapping("/boxes")
    public ResponseEntity<Object> createBox(@RequestBody Box box) {
        Box savedBox = repository.save(box);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBox.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
