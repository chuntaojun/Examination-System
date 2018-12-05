package com.tensor.org.dao.config;

/**
 * @author liaochuntao
 */
public enum DataSourceType {

    /**
     * 数据库主库
     */
    MASTER_DB(1, "master"),
    /**
     * 数据库从库
     */
    SALVE_ONE(2, "slave-one"),
    /**
     * QUARTZ 任务数据库
     */
    QUARTZ_DB(3, "quartz_master")
    ;

    private int value;
    private String type;

    DataSourceType(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "DataSourceType{" +
                "value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
