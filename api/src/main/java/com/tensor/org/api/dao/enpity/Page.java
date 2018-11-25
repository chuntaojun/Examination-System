package com.tensor.org.api.dao.enpity;

import java.io.Serializable;

/**
 * 分页传递参数
 * @author liaochuntao
 */
public class Page implements Serializable {

    private long limit;
    private long offset;
    private long totalNum;
    private String maxId;

    public Page() {
    }

    public Page(long limit, long offset, long totalNum) {
        this.limit = limit;
        this.offset = offset;
        this.totalNum = totalNum;
    }

    public long getLimit() {
        return limit;
    }

    public long getOffset() {
        return offset;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public static class Builder {

        private Page page;

        public Builder() {
            page = new Page();
        }

        public Builder limit(long limit) {
            page.limit = limit;
            return this;
        }

        public Builder offset(long offset) {
            page.offset = offset;
            return this;
        }

        public Builder totalNum(long totalNum) {
            page.totalNum = totalNum;
            return this;
        }

        public Page builded() {
            return page;
        }

    }

}
