package com.tensor.org.api.dao.enpity.log;

import lombok.Data;

import java.util.Date;

/**
 * @author liaochuntao
 */
public class LogApiRequestPO {

    private String url;
    private String method;
    private String handler;
    private Date lastRequestTime;
    private Date lastFailRequestTime;
    private long lastRequestSpend;
    private long requestCount;
    private long maxSpendTime;
    private long totalSpendTime;
    private double averageSpendTime;
    private long successRequestCount;
    private long failRequestCount;
    private String errInfo;

    public LogApiRequestPO() {
    }

    public LogApiRequestPO(String url, String method, String handler, Date lastRequestTime, Date lastFailRequestTime, long lastRequestSpend, long requestCount, long maxSpendTime, long totalSpendTime, double averageSpendTime, long successRequestCount, long failRequestCount, String errInfo) {
        this.url = url;
        this.method = method;
        this.handler = handler;
        this.lastRequestTime = lastRequestTime;
        this.lastFailRequestTime = lastFailRequestTime;
        this.lastRequestSpend = lastRequestSpend;
        this.requestCount = requestCount;
        this.maxSpendTime = maxSpendTime;
        this.totalSpendTime = totalSpendTime;
        this.averageSpendTime = averageSpendTime;
        this.successRequestCount = successRequestCount;
        this.failRequestCount = failRequestCount;
        this.errInfo = errInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Date getLastRequestTime() {
        return lastRequestTime;
    }

    public void setLastRequestTime(Date lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }

    public Date getLastFailRequestTime() {
        return lastFailRequestTime;
    }

    public void setLastFailRequestTime(Date lastFailRequestTime) {
        this.lastFailRequestTime = lastFailRequestTime;
    }

    public long getLastRequestSpend() {
        return lastRequestSpend;
    }

    public void setLastRequestSpend(long lastRequestSpend) {
        this.lastRequestSpend = lastRequestSpend;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public long getMaxSpendTime() {
        return maxSpendTime;
    }

    public void setMaxSpendTime(long maxSpendTime) {
        this.maxSpendTime = maxSpendTime;
    }

    public long getTotalSpendTime() {
        return totalSpendTime;
    }

    public void setTotalSpendTime(long totalSpendTime) {
        this.totalSpendTime = totalSpendTime;
    }

    public double getAverageSpendTime() {
        return averageSpendTime;
    }

    public void setAverageSpendTime(double averageSpendTime) {
        this.averageSpendTime = averageSpendTime;
    }

    public long getSuccessRequestCount() {
        return successRequestCount;
    }

    public void setSuccessRequestCount(long successRequestCount) {
        this.successRequestCount = successRequestCount;
    }

    public long getFailRequestCount() {
        return failRequestCount;
    }

    public void setFailRequestCount(long failRequestCount) {
        this.failRequestCount = failRequestCount;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }

    @Override
    public String toString() {
        return "LogApiRequestPO{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", handler='" + handler + '\'' +
                ", lastRequestTime=" + lastRequestTime +
                ", lastFailRequestTime=" + lastFailRequestTime +
                ", lastRequestSpend=" + lastRequestSpend +
                ", requestCount=" + requestCount +
                ", maxSpendTime=" + maxSpendTime +
                ", totalSpendTime=" + totalSpendTime +
                ", averageSpendTime=" + averageSpendTime +
                ", successRequestCount=" + successRequestCount +
                ", failRequestCount=" + failRequestCount +
                ", errInfo='" + errInfo + '\'' +
                '}';
    }
}
