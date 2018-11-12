package com.tensor.org.dao.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.user.UserVO;
import com.tensor.org.dao.mapper.user.UserVOMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class UserVODaoImpl implements com.tensor.org.api.dao.user.UserVODao {

    @Resource
    private UserVOMapper userVOMapper;

    @Override
    public ResultData<UserVO> findOneUserVO(String login) {
        return null;
    }

    @Override
    public ResultData<List<UserVO>> findAllUserVO() {
        return null;
    }

    @Override
    public ResultData save(UserVO userVO, int curdType) {
        return null;
    }

    @Override
    public ResultData deleteUserVO(String userId) {
        return null;
    }
}
