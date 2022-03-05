package com.buuhvprojects.userauth.application.interfaces


enum class UserRole {
    user, editor, admin, gestor
}

data class User (
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String?,
    val role: UserRole,
    val isCompany: Boolean,
    val createdAt: String,
) {
}