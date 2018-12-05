package com.tensor.org.api.dao.log;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface ApiRequestDao {

    ResultData<String> save(String info);

    ResultData<List<String>> findAllApiRequestLog(Page page);

}
