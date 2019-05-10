package com.tensor.org.api;

import java.io.Serializable;

/**
 * 全局设置返回消息包装类
 * @author liaochuntao
 */
public class ResultData<V> implements Serializable {

    private static final long serialVersionUID = 6674999278660577990L;

    private int code;
    private String errMsg;
    private V value;

    public ResultData() {
    }

    public ResultData(int code, String errMsg, V value) {
        this.code = code;
        this.errMsg = errMsg;
        this.value = value;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCode() {
        return code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public V getValue() {
        return value;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static  Builder builder() {
        return new Builder();
    }

    /**
     * 建造者模式
     * @param 
     */
    public static class Builder<V> {

        private ResultData resultData;

        Builder() {
            resultData = new ResultData();
        }

        public Builder code(int code) {
            resultData.code = code;
            return this;
        }

        public Builder errMsg(String errMsg) {
            resultData.errMsg = errMsg;
            return this;
        }

        public Builder value(V value) {
            resultData.value = value;
            return this;
        }

        public ResultData builded() {
            return resultData;
        }
    }

}
