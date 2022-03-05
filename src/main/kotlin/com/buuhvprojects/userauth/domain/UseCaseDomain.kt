package com.buuhvprojects.userauth.domain

import com.buuhvprojects.userauth.application.interfaces.APIReturn

interface UseCaseDomain {
    val response: APIReturn;
    fun result(): APIReturn;
    fun init();
}