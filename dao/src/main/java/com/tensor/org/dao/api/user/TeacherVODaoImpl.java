package com.tensor.org.dao.api.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.user.TeacherVO;
import com.tensor.org.dao.mapper.user.TeacherVOMapper;
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
public class TeacherVODaoImpl implements com.tensor.org.api.dao.user.TeacherVODao {

    @Resource private TeacherVOMapper teacherVOMapper;

    @Transactional
    @Override
    public ResultData save(TeacherVO teacherVO, int curdType) {
        return null;
    }

    @Override
    public ResultData<TeacherVO> findTeachVOByTeaNo(String teacherNo) {
        return null;
    }

    @Override
    public ResultData<List<TeacherVO>> findAllTeacherVO(Page page) {
        return null;
    }

}
