package com.tensor.org.work.utils;

import com.google.gson.Gson;

public class JsonUtils<T> {

    private volatile static Gson gson;

    static {
        gson = new Gson();
    }

    private JsonUtils() {}

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T> Object toObj(String s, T t) {
        return gson.fromJson(s, t.getClass());
    }

}
