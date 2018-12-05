package com.tensor.org.api.user;

/**
 * @author liaochuntao
 */

public enum NoticeType {
    /**
     *
     */
    NOTICE_ALL(0, "all"),

    /**
     *
     */
    NOTICE_ALL_STUDENT(1, "all_student"),

    /**
     *
     */
    NOTICE_ALL_TEACHER(2, "all_teacher"),

    /**
     *
     */
    NOTICE_BY_GROUP(3, "by_group"),

    /**
     *
     */
    NOTICE_SINGLE_USER(4, "single_user")
    ;

    private int value;
    private String label;

    NoticeType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
