package com.tensor.org.api.dao.enpity;

import com.tensor.org.api.utils.BusinessType;

import java.io.Serializable;

/**
 * 查询条件
 * @author liaochuntao
 */
public class SearchConditionPO implements Serializable {

    private static final long serialVersionUID = -1830668110327394061L;

    private BusinessType.SearchConditionType searchConditionType;

    /**
     * 查询内容
     */
    private String queryBody;

    public SearchConditionPO() {
    }

    public SearchConditionPO(BusinessType.SearchConditionType searchConditionType, String queryBody) {
        this.searchConditionType = searchConditionType;
        this.queryBody = queryBody;
    }

    public BusinessType.SearchConditionType getSearchConditionType() {
        return searchConditionType;
    }

    public void setSearchConditionType(BusinessType.SearchConditionType searchConditionType) {
        this.searchConditionType = searchConditionType;
    }

    public String getQueryBody() {
        return queryBody;
    }

    public void setQueryBody(String queryBody) {
        this.queryBody = queryBody;
    }

    @Override
    public String toString() {
        return "SearchConditionPO{" +
                "searchConditionType=" + searchConditionType +
                ", queryBody='" + queryBody + '\'' +
                '}';
    }
}
