package me.tcpackfrequency.Warehouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }
}
