package com.miniproject.todo.resources;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResources {
    @RequestMapping(value="/hello",method = {RequestMethod.GET})
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/{user}")
    public String welcomeUser(@PathVariable String user){
        return "<h1>Welcome "+user+"</h1>";
    }
}
