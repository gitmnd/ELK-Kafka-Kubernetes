package com.shopping.ecom.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class CommController {

    @GetMapping("/users")
    public List<String> getUsers(){
        return Arrays.asList("John","Kick","Sri");
    }

    @GetMapping("/location")
    public List<String> getLocation(){
        return Arrays.asList("US","UK","Coimbatore");
    }
}
