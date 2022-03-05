package com.buuhvprojects.userauth.infrastructure.repositories

import com.buuhvprojects.userauth.application.interfaces.User
import com.buuhvprojects.userauth.application.interfaces.UserRole
import java.util.Date

class UserRepositoryMysql {
    companion object {
        @JvmStatic
        fun findByEmail(email: String, fields: Array<String>): User? {
            return User(
                "User",
                "Test",
                "teste@gmail.com",
                null,
                UserRole.user,
                false,
                Date().toString()
            );
        }
    }
}