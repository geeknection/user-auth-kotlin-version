package com.buuhvprojects.userauth.application.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import java.util.*

class JWT {

    @Value("jwt.secret")
    private val secret: String? = null

    fun register(params: Map<String, Any>): JwtBuilder? {
        val token = Jwts.builder().setIssuedAt(Date(System.currentTimeMillis()));
        if (params["expires"] as Boolean) {
            token.setExpiration(Date(System.currentTimeMillis() + params["expires"] as Long * 1000))
        }
        token.setClaims(params.filterKeys { key -> key !== "expires" });
        token.signWith(SignatureAlgorithm.ES256, secret).compact();
        return token;
    }

    fun data(token: String): Claims? {
        val tokenData = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body;
        return tokenData;
    }

    //validate token
    fun validate(token: String): Boolean {
        try {
            val tokenData = this.data(token);
            if (tokenData.isNullOrEmpty()) {
                return false;
            }
            if (tokenData["expires"] as Boolean) {
                return tokenData.expiration.before(Date())
            }
            return true;
        } catch (e: Exception) {
            return false;
        }
    }
}