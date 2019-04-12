package com.tensor.org.dao.config;

/**
 * @author liaochuntao
 */
public class JdbcContextHolder {

    private final static ThreadLocal<String> DB_CHOSE = ThreadLocal.withInitial(DataSourceType.MASTER_DB::getType);

    static String get() {
        return DB_CHOSE.get();
    }

    public static void set(DataSourceType dbType) {
        DB_CHOSE.set(dbType.getType());
    }

}
