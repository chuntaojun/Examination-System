package com.tensor.org.dao.config;

/**
 * @author liaochuntao
 */
public class JdbcContextHolder {

    private final static ThreadLocal<String> dbChose = new ThreadLocal<>();

    public static String get() {
        return dbChose.get();
    }

    public static void set(DataSourceType dbType) {
        dbChose.set(dbType.getType());
    }

}
