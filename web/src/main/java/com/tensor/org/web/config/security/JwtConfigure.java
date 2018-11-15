package com.tensor.org.web.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liaochuntao
 */
@Configuration
public class JwtSecurityConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean(value = "JwtTokenAlgorithm")
    public Algorithm create() {
        return Algorithm.HMAC256(jwtSecret);
    }

    public String createSign() {
    }

}
