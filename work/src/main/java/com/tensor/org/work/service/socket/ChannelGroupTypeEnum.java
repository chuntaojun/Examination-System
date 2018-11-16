package com.tensor.org.work.service.socket;

/**
 * @author liaochuntao
 */

public enum ChannelGroupTypeEnum {

    /**
     * 学生消息通道分组
     */
    CHANNEL_GROUP_STUDENT(1, "channel_student"),

    /**
     * 教师消息通道分组
     */
    CHANNEL_GROUP_TEACHER(2, "channel_teacher"),

    /**
     *
     */
    CHANNEL_GROUP_GLOBAL(3, "channel_global")
    ;

    private int value;
    private String type;

    ChannelGroupTypeEnum(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
