package com.tensor.org.web.config.filter;

import com.tensor.org.web.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
@Slf4j
@Configuration
@PropertySource(value = {"classpath:url.properties"}, encoding="utf-8")
public class WebFluxFilterConfigure implements WebFilter {

    @Autowired private JwtTokenUtils jwtTokenUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().toString();
        return chain.filter(exchange);
    }

}
