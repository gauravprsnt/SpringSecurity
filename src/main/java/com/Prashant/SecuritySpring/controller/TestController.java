package com.Prashant.SecuritySpring.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @GetMapping(value = "/test")
    public String getTest(@AuthenticationPrincipal UserDetails userDetails){
        String currentUser=userDetails.getUsername();
        return "Hello From User";
        }

        @GetMapping(value = "/admin")
    public String getForAdmin(){
        return "Hello From Admin";
        }
}
