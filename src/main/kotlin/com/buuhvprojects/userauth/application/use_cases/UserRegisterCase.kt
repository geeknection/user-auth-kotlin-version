package com.buuhvprojects.userauth.application.use_cases

import com.buuhvprojects.userauth.application.interfaces.APIReturn
import com.buuhvprojects.userauth.application.interfaces.UserRegisterData
import com.buuhvprojects.userauth.domain.UseCaseDomain
import com.buuhvprojects.userauth.domain.UserRegisterDomain
import com.buuhvprojects.userauth.infrastructure.repositories.UserRepository

class UserRegisterCase : UseCaseDomain {
    override val response = APIReturn();
    private var userData: UserRegisterData;
    constructor(userRegisterData: UserRegisterData) {
        this.userData = userRegisterData;
    }
    override fun init() {
        val registerDomain = UserRegisterDomain(this.userData);

        val fields = arrayOf("id");
        val user = UserRepository.findByEmail(registerDomain.email, fields);
        if (user !== null) {
            this.response.status = false;
            this.response.message = "Usuário já existente com esse email";
            return;
        }

        //val userId = UserRepositoryMysql.insert(register);
        //this.response.values = userId;
    }

    override fun result(): APIReturn {
        return this.response;
    }
}
