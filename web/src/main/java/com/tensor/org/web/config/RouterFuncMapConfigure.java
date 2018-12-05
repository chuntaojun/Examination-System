package com.tensor.org.web.config;

import com.tensor.org.web.aop.HttpFilterAspect;
import com.tensor.org.web.config.filter.RegisterUrlContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.handler.AbstractHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

/**
 * 多路由注册
 * @author liaochuntao
 */
@Slf4j
@Configuration
public class RouterFuncMapConfigure extends AbstractHandlerMapping implements InitializingBean {

    @Autowired private RegisterUrlContainer urlContainer;
    @Autowired private HttpFilterAspect httpFilterAspect;

    @Nullable
    private RouterFunction<?> routerFunction;

    private List<HttpMessageReader<?>> messageReaders = Collections.emptyList();

    @Override
    public void afterPropertiesSet() {
        if (CollectionUtils.isEmpty(this.messageReaders)) {
            ServerCodecConfigurer codecConfigurer = ServerCodecConfigurer.create();
            this.messageReaders = codecConfigurer.getReaders();
        }
        if (this.routerFunction == null) {
            initRouterFunctions();
        }
    }

    private void initRouterFunctions() {
        List<RouterFunction<?>> routerFunctions = routerFunctions();
        this.routerFunction = routerFunctions
                .stream()
                .reduce(RouterFunction::andOther)
                .orElse(null);
    }

    private List<RouterFunction<?>> routerFunctions() {
        SortedRouterFunctionsContainer container = new SortedRouterFunctionsContainer();
        obtainApplicationContext().getAutowireCapableBeanFactory().autowireBean(container);
        List<RouterFunction<?>> routerFunctions = CollectionUtils
                .isEmpty(container.routerFunctions) ? Collections.emptyList() : container.routerFunctions;
        urlContainer.init(routerFunctions);
        httpFilterAspect.init(urlContainer.getUrlContainer());
        return routerFunctions;
    }

    @Override
    protected Mono<?> getHandlerInternal(ServerWebExchange exchange) {
        return Mono.empty();
    }

    private static class SortedRouterFunctionsContainer {

        @Nullable
        private List<RouterFunction<?>> routerFunctions;

        @Autowired(required = false)
        public void setRouterFunctions(List<RouterFunction<?>> routerFunctions) {
            this.routerFunctions = routerFunctions;
        }
    }

}
