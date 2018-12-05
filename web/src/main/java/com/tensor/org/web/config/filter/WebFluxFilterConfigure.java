package com.tensor.org.web.config.filter;

import com.tensor.org.api.dao.enpity.user.JwtUser;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.web.config.security.SecurityConfigure;
import com.tensor.org.web.utils.JwtTokenUtils;
import com.tensor.org.web.utils.StringsValue;
import com.tensor.org.web.utils.exception.NotAuthorizationException;
import com.tensor.org.web.utils.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
 * @author liaochuntao
 */
@Slf4j
@Configuration
@PropertySource(value = {"classpath:url.properties"}, encoding = "utf-8")
public class WebFluxFilterConfigure implements WebFilter {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private SecurityConfigure securityConfigure;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        Tuple2<Boolean, Boolean> tuple2 = requireAuthorization(request.getPath().toString(), request);
        if (tuple2.getT1()) {
            return chain.filter(exchange);
        } else if (!tuple2.getT1() && tuple2.getT2()) {
            return chain.filter(exchange);
        } else {
            throw new NotAuthorizationException(StringsValue.CN.NOT_AUTHORIZATION);
        }
    }

    private Tuple2<Boolean, Boolean> requireAuthorization(String url, ServerHttpRequest request) {
        log.info("url : {}", url);
        return securityConfigure.getSecurityUrls().entrySet()
                .parallelStream()
                .filter(patternStringEntry -> patternStringEntry.getKey().matcher(url).find())
                .map(patternStringEntry -> Tuples.of(false, patternStringEntry))
                .map(tuple2 -> {
                    AtomicBoolean haveAuthorization = new AtomicBoolean(true);
                    List<String> token = request.getHeaders().get("Authorization");
                    if (token == null || token.isEmpty()) {
                        throw new NotLoginException(StringsValue.CN.NOT_LOGIN);
                    }
                    jwtTokenUtils.tokenVerify(token.get(0)).ifPresent(decodedJWT -> {
                        JwtUser jwtUser = (JwtUser) JsonUtils.toObj(decodedJWT.getSubject(), JwtUser.class);
                        haveAuthorization.set(jwtUser.getRole().equalsIgnoreCase(tuple2.getT2().getValue()));
                    });
                    return Tuples.of(tuple2.getT1(), haveAuthorization.get());
                }).findFirst().orElse(Tuples.of(true, true));
    }

}
