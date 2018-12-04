package com.tensor.org.web.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.user.JwtUser;
import com.tensor.org.api.dao.enpity.user.UserVO;
import com.tensor.org.api.utils.BusinessType;
import com.tensor.org.api.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.tensor.org.web.utils.PropertiesEnum.Jwt.*;
import static com.tensor.org.web.utils.StringsValue.CN.INCORRECT_LOGIN_PASSWORD;

/**
 * @// FIXME: 2018/12/3 遗留token刷新机制的问题
 * @author liaochuntao
 */
@Slf4j
@Component
public class JwtTokenUtils {

    private final static String ISSUSER = "TENSOR";

    @Autowired
    @Qualifier(value = "JwtTokenAlgorithm")
    private Algorithm algorithm;

    private JwtUser jwtUser;

    public JwtTokenUtils login(UserVO user, Optional<UserVO> voOptional) {
        voOptional.ifPresent(userDB -> {
            log.info("userDB : {}", userDB);
            if (user.getPassword().equals(userDB.getPassword())) {
                jwtUser = new JwtUser();
                jwtUser.setRole(BusinessType.RoleType.getRoleName(userDB.getRoles()));
                jwtUser.setUserId(userDB.getUserId());
            }
        });
        return this;
    }

    @SuppressWarnings("unchecked")
    public Mono<ResultData> createSign() {
        if (jwtUser == null) {
            return Mono.just(ResultData.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .errMsg(INCORRECT_LOGIN_PASSWORD)
                    .builded());
        }
        return Mono.just(new Date()).map(date -> {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.SECOND, TOKEN_SURVIVAL_MILLISECOND.getValue());
            return calendar;
        }).map(calendar -> Tuples.of(calendar, new HashMap<>()))
                .map(data -> {
                    data.getT2().put("token", JWT
                            .create()
                            .withIssuer(ISSUSER)
                            .withSubject(JsonUtils.toJson(jwtUser))
                            .withExpiresAt(data.getT1().getTime())
                            .sign(algorithm));
                    data.getT2().put("userId", jwtUser.getUserId());
                    return data.getT2();
                }).flatMap(map -> Mono.just(ResultData.builder()
                        .code(HttpStatus.OK.value())
                        .value(map)
                        .errMsg("")
                        .builded()));
    }

    public Mono<ResultData> refresh(DecodedJWT decodedJWT) {
        this.jwtUser = (JwtUser) JsonUtils.toObj(decodedJWT.getSubject(), JwtUser.class);
        return createSign();
    }

    /**
     * @param jwt
     * @return
     */
    public Optional<DecodedJWT> tokenVerify(String jwt) {
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUSER).build();
            decodedJWT = verifier.verify(jwt);
        } catch (JWTVerificationException exception) {
            log.error(exception.getMessage());
        }
        return Optional.ofNullable(decodedJWT);
    }

    /**
     * @param decodedJWT
     * @return
     */
    public PropertiesEnum.Jwt isExpire(DecodedJWT decodedJWT) {
        long timeMisc = decodedJWT.getExpiresAt().getTime() - System.currentTimeMillis();
        if (timeMisc < 0) {
            return TOKEN_STATUS_EXXPIRE;
        }
        if (timeMisc <= TOKEN_EXPIRE_RANGE.getValue()) {
            return TOKEN_STATUS_REFRESH;
        }
        return TOKEN_STATUS_HEALTH;
    }

}
