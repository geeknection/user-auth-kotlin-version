package com.buuhvprojects.userauth.common.config

class AppConfig {
    companion object {
        @JvmStatic
        fun getPort(): Int {
            return 3000;
        }
    }
}