package com.tensor.org.dao.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.validation.MethodValidated;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.user.UserVO;
import com.tensor.org.dao.mapper.user.UserVOMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        UserVO userVO = userVOMapper.findOneUserVO(login);
        return ResultData.builder().value(userVO).builded();
    }

    @Override
    public ResultData<List<UserVO>> findAllUserVO(Page page) {
        return null;
    }

    @Transactional
    @Override
    public ResultData save(UserVO userVO, int curdType) {
        return null;
    }

    @Transactional
    @Override
    public ResultData deleteUserVOBatch(List<String> userIds) {
        return null;
    }

}
