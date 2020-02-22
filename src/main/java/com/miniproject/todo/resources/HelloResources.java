package com.miniproject.todo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResources {
    @RequestMapping(value="/",method = {RequestMethod.GET})
    public String sayHello(){
        return "welcome";
    }
}
