package com.tensor.org.api.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author liaochuntao
 */
public class JsonUtils<T> {

    private volatile static Gson gson;

    static {
        gson = new Gson();
    }

    private JsonUtils() {}

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    @SuppressWarnings("nochecked")
    public static <T> Object toObj(String s, T t) {
        return gson.fromJson(s, (Type) t);
    }

}
