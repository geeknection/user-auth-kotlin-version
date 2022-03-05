package com.buuhvprojects.userauth

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.buuhvprojects.userauth.interfaces.routes.PostRoutes

@RestController
class BuuhVRoutes {
    @PostMapping
    fun runPost(): PostRoutes {
        return PostRoutes()
    }
}