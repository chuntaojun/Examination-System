package com.tensor.org.work.service.compiler;

import com.tensor.org.work.service.compiler.support.CompilerResult;

/**
 * @author liaochuntao
 */
public interface TensorCompilerService {

    CompilerResult compiler(String javaName, String source);

}
