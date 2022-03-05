package com.buuhvprojects.userauth.application.interfaces

import org.jetbrains.annotations.NotNull

data class UserRegisterData (
    @field:NotNull
    val firstName: String,
    @field:NotNull
    val lastName: String,
    @field:NotNull
    val email: String,
    @field:NotNull
    val password: String,
    @field:NotNull
    val isCompany: Boolean,
) {

}