package com.tensor.org.dao.api.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.user.StudentVO;
import com.tensor.org.dao.aop.Dynamic;
import com.tensor.org.dao.config.DataSourceType;
import com.tensor.org.dao.mapper.user.StudentVOMapper;
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
public class StudentVODaoImpl implements com.tensor.org.api.dao.user.StudentVODao {

    @Resource private StudentVOMapper studentVOMapper;

    @Dynamic(value = DataSourceType.MASTER_DB)
    @Transactional
    @Override
    public ResultData save(StudentVO studentVO, int curdType) {
        return null;
    }

    @Dynamic(value = DataSourceType.SALVE_ONE)
    @Override
    public ResultData<StudentVO> findStuVOByStuNo(String stuNo) {
        return null;
    }

    @Override
    public ResultData<List<StudentVO>> findAllStuVOByOrgId(String orgId) {
        return null;
    }
}
