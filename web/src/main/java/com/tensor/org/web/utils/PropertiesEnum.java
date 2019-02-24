package com.tensor.org.web.utils;

public final class PropertiesEnum {

    public enum Jwt {

        /**
         *
         */
        TOKEN_STATUS_EXXPIRE(-1, "token had expire"),

        /**
         *
         */
        TOKEN_STATUS_REFRESH(0, "token should be refresh"),

        /**
         *
         */
        TOKEN_STATUS_HEALTH(1, "token is alive"),

        /**
         * json web token 存活秒数
         */
        TOKEN_SURVIVAL_MILLISECOND(30 * 60),

        /**
         *
         */
        TOKEN_EXPIRE_RANGE(10);

        private int value;
        private String doc;

        Jwt(int value) {
            this.value = value;
        }

        Jwt(int value, String doc) {
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
}
