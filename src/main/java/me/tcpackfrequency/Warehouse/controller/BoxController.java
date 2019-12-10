package me.tcpackfrequency.Warehouse.controller;

import me.tcpackfrequency.Warehouse.model.Box;
import me.tcpackfrequency.Warehouse.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public void updateBox(@RequestBody Box box, @PathVariable int id) {
        List<Box> boxes = repository.findAll();
        for(Box foundbox : boxes){
            if(box.getSector() == foundbox.getSector() && box.getPosition() == foundbox.getPosition()){
                repository.save(box);
            }
        }
    }

    @DeleteMapping("/boxes/{id}")
    public void deleteBox(@PathVariable int id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/boxes")
    public ResponseEntity<Object> deleteBoxByJSON(@RequestBody Box box){
        for(Box found : repository.findAll()) {
            if(box.getSector() == found.getSector()) {
                if(box.getPosition() == found.getPosition()) {
                    repository.delete(found);
                    return ResponseEntity.noContent().build();
                }
            }
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/boxes")
    public ResponseEntity<Object> createBox(@RequestBody Box box) {
        List<Box> boxes = repository.findAll();
        for(Box found : boxes){
            if(box.getSector() == found.getSector() && box.getPosition() == found.getPosition()) {
                Optional<Box> f = repository.findById(found.getId());
                f.get().setContent(box.getContent());
                f.get().setQuantity(box.getQuantity());
                f.get().setPr(box.isPr());
                repository.save(f.get());
                return ResponseEntity.noContent().build();
            }
        }
        Box savedBox = repository.save(box);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBox.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
