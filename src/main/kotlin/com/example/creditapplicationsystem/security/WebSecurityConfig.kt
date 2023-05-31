package com.example.creditapplicationsystem.security

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyController {
    @GetMapping("/endpoint")
    fun endpoint(): String {
        return "endpoint"
    }
}

/*
@Bean
SecurityFilterChain web(HttpSecurity http) throws Exception {
    http {
        authorizeHttpRequests {
            authorize("/endpoint", hasAuthority('USER'))
            authorize(anyRequest, authenticated)
        }
    }
    return http.build();
}*/
