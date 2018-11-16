package com.tensor.org.web.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tensor.org.api.dao.enpity.user.JwtUser;
import com.tensor.org.api.dao.enpity.user.UserVO;
import com.tensor.org.api.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static com.tensor.org.web.utils.PropertiesEnum.Jwt.*;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class JwtTokenUtils {

    @Autowired
    @Qualifier(value = "JwtTokenAlgorithm")
    private Algorithm algorithm;

    /**
     *
     * @param jwtUser
     * @return
     */
    public String createSign(JwtUser jwtUser) {
        Date expire = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(expire);
        calendar.add(Calendar.MILLISECOND, TOKEN_SURVIVAL_MILLISECOND.getValue());
        return JWT
                .create()
                .withIssuer(jwtUser.getUserId())
                .withSubject(JsonUtils.toJson(jwtUser))
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }

    /**
     *
     * @param jwt
     * @param userId
     * @return
     */
    public Optional<DecodedJWT> tokenVerify(String jwt, String userId) {
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(userId).build();
            decodedJWT = verifier.verify(jwt);
        } catch (JWTVerificationException exception) {
            log.error(exception.getMessage());
        }
        return Optional.ofNullable(decodedJWT);
    }

    /**
     *
     * @param decodedJWT
     * @return
     */
    public int isExpire(DecodedJWT decodedJWT) {
        long timeMisc = decodedJWT.getExpiresAt().getTime() - System.currentTimeMillis();
        if (timeMisc < 0) {
            return TOKEN_STATUS_EXXPIRE.getValue();
        }
        if (timeMisc <= TOKEN_EXPIRE_RANGE.getValue()) {
            return TOKEN_STATUS_REFRESH.getValue();
        }
        return TOKEN_STATUS_HEALTH.getValue();
    }

}
