package com.buuhvprojects.userauth.domain

import com.buuhvprojects.userauth.application.interfaces.UserRegisterData

class UserRegisterDomain {
    var firstName: String = "";
    var lastName: String = "";
    var email: String = "";
    var password: String = "";
    var isCompany: UserCompanyEnum = UserCompanyEnum.YES;
    constructor(user: UserRegisterData) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.password = user.password;
        this.email = user.email;
        if (user.isCompany === false) {
            this.isCompany = UserCompanyEnum.NOT;
        }
    }
}