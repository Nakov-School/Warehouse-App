package me.tcpackfrequency.Warehouse.controller;

import me.tcpackfrequency.Warehouse.model.Box;
import me.tcpackfrequency.Warehouse.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SectorController {

    @Autowired
    private BoxRepository repository;

    @GetMapping("/sector/{id}")
    public List<Box> boxes(@PathVariable int id){
        return repository.findAll().stream()
                .filter(b -> b.getSector() == id)
                .collect(Collectors.toList());
    }
}
