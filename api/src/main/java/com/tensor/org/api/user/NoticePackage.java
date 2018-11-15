package com.tensor.org.api.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liaochuntao
 */
@Data
@Builder
public class NoticePackage {

    private String userId;
    private String orgId;
    private List<String> receivers;
    private int groupType;
    private String message;
    private long totalReceivers;

}
