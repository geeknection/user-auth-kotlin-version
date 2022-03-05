package com.buuhvprojects.userauth.interfaces.routes

import com.buuhvprojects.userauth.application.interfaces.APIReturn
import com.buuhvprojects.userauth.application.interfaces.UserRegisterData
import com.buuhvprojects.userauth.interfaces.controllers.UserControllers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.annotation.RequestScope
import javax.servlet.http.HttpServletRequest


@RestController
class PostRoutes {
    @RequestMapping("/v1/register")
    fun register(
        @RequestBody userRegisterData: UserRegisterData,
        @Autowired request: HttpServletRequest
    ): ResponseEntity<APIReturn> {
        return try {
            ResponseEntity.status(200).body(
                UserControllers(request).register(userRegisterData)
            )
        } catch (e: Exception) {
            val response = APIReturn();
            response.status = false;
            response.message = e.message;
            ResponseEntity.status(503).body(response)
        }
    }
}