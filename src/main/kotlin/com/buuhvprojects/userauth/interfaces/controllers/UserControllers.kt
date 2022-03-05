package com.buuhvprojects.userauth.interfaces.controllers

import com.buuhvprojects.userauth.application.interfaces.APIReturn
import com.buuhvprojects.userauth.application.interfaces.UserRegisterData
import com.buuhvprojects.userauth.application.use_cases.UserRegisterCase
import org.springframework.stereotype.Controller
import javax.servlet.http.HttpServletRequest

@Controller
class UserControllers {
    private var req: HttpServletRequest;
    constructor(req: HttpServletRequest) {
        this.req = req;
    }
    fun register(userRegisterData: UserRegisterData): APIReturn {
        val response = APIReturn();
        return try {
            val register = UserRegisterCase(userRegisterData);
            register.init();
            register.result();
        } catch (e: Exception) {
            response.status = false;
            response.message = e.message;
            response;
        }
    }
}