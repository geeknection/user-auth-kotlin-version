package com.buuhvprojects.userauth

import com.buuhvprojects.userauth.common.config.AppConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*


@SpringBootApplication
class Server {
   companion object {
       @JvmStatic
       fun main(args: Array<String>) {
           val app = SpringApplication(Server::class.java)
           app.setDefaultProperties(
               Collections
                   .singletonMap<String, Any>("server.port", AppConfig.getPort())
           )
           app.run(*args)
       }
   }
}