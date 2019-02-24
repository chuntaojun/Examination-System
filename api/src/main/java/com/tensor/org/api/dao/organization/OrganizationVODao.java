package com.tensor.org.api.dao.organization;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.organization.OrganizationVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface OrganizationVODao {

    /**
     * 根据组织编号查找对应的组织信息
     * @param orgId
     * @return
     */
    ResultData<OrganizationVO> findOrgVOById(String orgId);

    /**
     * 组织信息保存(根据curdType选择插入 or 更新)
     * @param organizationVO
     * @param curdType
     * @return
     */
    ResultData save(OrganizationVO organizationVO, int curdType);

    /**
     * 分页查找组织列表
     * @param page
     * @return
     */
    ResultData<List<OrganizationVO>> findAllOrgVO(Page page);

}
