package com.tensor.org.api.dao.user;


import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.user.UserVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface UserVODao {

    /**
     * 根据登陆名信息获取用户的账户信息
     * @param login
     * @return
     */
    ResultData findOneUserVO(String login);

    /**
     * 获取所有的账户信息
     * @param page {@link Page 分页对象}
     * @return
     */
    ResultData<List<UserVO>> findAllUserVO(Page page);

    /**
     * 保存用户账户(根据curdType选择插入 or 更新)
     * @param userVO {@link UserVO}
     * @return
     */
    ResultData save(UserVO userVO, int curdType);

    /**
     * 删除该账户
     * @param userIds
     * @return
     */
    ResultData deleteUserVOBatch(List<String> userIds);

}
