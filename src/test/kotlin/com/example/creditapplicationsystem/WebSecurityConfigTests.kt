package com.example.creditapplicationsystem

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebSecurityConfigTests {

    /*@WithMockUser(authorities = "USER")
    @Test
    fun endpointWhenUserAuthorityThenAuthorized() {
        this.mvc.perform(get("/endpoint"))
            .andExpect(status().isOk());
    }

    @WithMockUser
    @Test
    fun endpointWhenNotUserAuthorityThenForbidden() {
        this.mvc.perform(get("/endpoint"))
            .andExpect(status().isForbidden());
    }

    @Test
    fun anyWhenUnauthenticatedThenUnauthorized() {
        this.mvc.perform(get("/any"))
            .andExpect(status().isUnauthorized())
    }*/
}