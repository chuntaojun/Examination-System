package com.tensor.org.work.service.compiler.support;

import java.io.Serializable;

/**
 * @author liaochuntao
 */
public class CompilerResult implements Serializable {

    private boolean timeout;
    private Object result;
    private String compilerErr;
    private String printMsg;

    public CompilerResult() {
        this.timeout = true;
    }

    public boolean isTimeout() {
        return timeout;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getCompilerErr() {
        return compilerErr;
    }

    public void setCompilerErr(String compilerErr) {
        this.compilerErr = compilerErr;
    }

    public String getPrintMsg() {
        return printMsg;
    }

    public void setPrintMsg(String printMsg) {
        this.printMsg = printMsg;
    }
}
