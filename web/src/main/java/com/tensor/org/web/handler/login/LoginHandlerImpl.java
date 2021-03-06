package com.tensor.org.web.handler.login;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.user.UserVO;
import com.tensor.org.api.dao.user.UserVODao;
import com.tensor.org.web.utils.JwtTokenUtils;
import com.tensor.org.web.utils.ResponseAdaperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class LoginHandlerImpl implements LoginHandler {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "${dubbo.provider.url.dao}",
            timeout = 50000)
    private UserVODao userVODao;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(UserVO.class)
                .map(userVO -> {
                    final UserVO[] userDB = {null};
                    Optional<ResultData<UserVO>> oneUserVO = Optional.ofNullable(userVODao.findOneUserVO(userVO.getAccount()));
                    oneUserVO.ifPresent(userVOResultData -> userDB[0] = userVOResultData.getValue());
                    return jwtTokenUtils.login(userVO, Optional.ofNullable(userDB[0])).createSign();
                })
                .flatMap(ResponseAdaperUtils::render);
    }

    @Override
    public Mono<ServerResponse> logout(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> register(ServerRequest request) {
        return null;
    }
}
