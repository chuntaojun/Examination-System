package com.tensor.org.api.utils;

/**
 * @author liaochuntao
 */

public enum CurdTypeEnum {

    /**
     * 数据库查询操作
     */
    SELECT(0, "SELECT"),
    /**
     * 数据库插入操作
     */
    INSERT(1, "INSERT"),
    /**
     * 数据库更新操作
     */
    UPDATE(2, "UPDATE"),
    /**
     * 数据库删除操作
     */
    DELETE(3, "DELETE");

    private int value;
    private String doc;

    CurdTypeEnum(int value, String doc) {
        this.value = value;
        this.doc = doc;
    }

    public int getValue() {
        return value;
    }

    public String getDoc() {
        return doc;
    }
}
