package com.crystalprinter.grv;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hola {
    @RequestMapping("/")
    public String hola(){
        return "Hello Mario! The princess is in another Castle.";
    }
}
