package com.tensor.org.dao.mapper.user;


import com.tensor.org.dao.enpity.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaochuntao
 */
@Mapper
public interface UserVOMapper {

    /**
     * 根据登陆名信息获取用户的账户信息
     * @param login
     * @return
     */
    UserVO findOneUserVO(@Param(value = "login") String login);

    /**
     * 获取所有的账户信息
     * @return
     */
    List<UserVO> findAllUserVO();

    /**
     * 新增用户账户
     * @param userVO {@link UserVO}
     * @return
     */
    int saveUserVO(@Param(value = "userVO") UserVO userVO);

    /**
     * 更新用户账户信息
     * @param userVO
     * @return
     */
    int updateUserVOSelective(@Param("userVO") UserVO userVO);

    /**
     * 删除该账户
     * @param userId
     * @return
     */
    int deleteUserVO(@Param(value = "userId") String userId);

}