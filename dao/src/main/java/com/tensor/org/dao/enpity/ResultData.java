package com.tensor.org.dao.enpity;

import lombok.Builder;
import lombok.Data;

/**
 * @author liaochuntao
 */
@Data
@Builder
public class ResultData<V> {

    private int code;
    private String errMsg;
    private V value;

}
