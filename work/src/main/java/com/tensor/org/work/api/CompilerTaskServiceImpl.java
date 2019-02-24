package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.CompilerTaskPO;
import com.tensor.org.api.work.CompilerTaskService;
import com.tensor.org.work.service.compiler.TensorCompilerService;
import com.tensor.org.work.service.compiler.support.CompilerResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class CompilerTaskServiceImpl implements CompilerTaskService {

    @Autowired private TensorCompilerService compilerTaskService;

    @Override
    public ResultData createCompilerTask(CompilerTaskPO taskPO) {
        taskPO.setStartTime(System.currentTimeMillis());
        CompilerResult result = compilerTaskService.compiler(taskPO.getSourceName(), taskPO.getSourceCode());
        taskPO.setEndTime(System.currentTimeMillis());
        taskPO.setResult(new Gson().toJson(result));
        return ResultData.builder().value(taskPO).builded();
    }
}
