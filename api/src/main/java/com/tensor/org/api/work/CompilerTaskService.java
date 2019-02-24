package com.tensor.org.api.work;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.CompilerTaskPO;

public interface CompilerTaskService {

    ResultData createCompilerTask(CompilerTaskPO taskPO);

}
