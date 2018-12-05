package com.tensor.org.api.dao.enpity.log;

import lombok.Data;

import java.util.Date;

/**
 * @author liaochuntao
 */
@Data
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

}
