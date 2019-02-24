package com.tensor.org.work.service.compiler;

import com.tensor.org.work.service.compiler.support.CompilerPool;
import com.tensor.org.work.service.compiler.support.CompilerResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author liaochuntao
 */
@Slf4j
@Service
@Scope(value = "prototype")
public class TensorCompilerServiceImpl implements TensorCompilerService {

    @Autowired
    private CompilerPool compilerPool;

    @Override
    public CompilerResult compiler(String javaName, String source) {
        long startTime = System.currentTimeMillis();
        CompilerResult result;
        long maxWaitTimeSecond = 10;
        while ((result = compilerPool.work(javaName, source)).isTimeout()) {
            if ((System.currentTimeMillis() - startTime) / 1000 >= maxWaitTimeSecond) {
                break;
            }
        }
        return result;
    }
}
