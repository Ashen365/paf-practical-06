package com.example.demo;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public EntityModel<Greeting> greeting() {
        Greeting greeting = new Greeting("Hello, World!");

        return EntityModel.of(greeting,
                linkTo(methodOn(GreetingController.class).greeting()).withSelfRel());
    }
}
