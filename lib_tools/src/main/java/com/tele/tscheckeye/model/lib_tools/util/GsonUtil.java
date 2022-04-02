package com.tele.tscheckeye.model.lib_tools.util;

import com.solidfire.gson.Gson;
import com.solidfire.gson.JsonArray;
import com.solidfire.gson.JsonElement;
import com.solidfire.gson.JsonParser;
import com.solidfire.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Gson工具类
 * 1，json转对象class
 * 2，json转对象type
 * 3，对象转json
 * 4，json转list
 * 5，json转map
 * 6，
 */
public class GsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private GsonUtil() {
    }

    /**
     * json转对象
     *
     * @param gsonString json格式的字符串
     * @param cls 实体类
     * @param <T>
     * @return
     */
    public static <T> T gsonToBean(String gsonString, Class<T> cls) {
        T T = null;
        try {
            if (gson != null) {
                T = gson.fromJson(gsonString, cls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return T;
    }

    /**
     * json转对象
     *
     * @param gsonString json格式的字符串
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T gsonToBean(String gsonString, Type type) {
        T T = null;
        try {
            if (gson != null) {
                T = gson.fromJson(gsonString, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return T;
    }


    /**
     * 转成json
     *
     * @param object 实体类
     * @return 返回json格式的字符串
     */
    public static String gsonToJson(Object object) {
        String gsonString = null;
        try {
            if (gson != null) {
                gsonString = gson.toJson(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gsonString;
    }

    /**
     * 转成list
     *
     * @param gsonString json格式的字符串
     * @param cls 实体类
     * @return 返回实体类的list集合
     */
    public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();
            for (JsonElement jsonElement : array) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 转成list中有map的
     *
     * @param gsonString json格式的字符串
     * @return 返回list集合
     */
    public <T> List<Map<String, T>> gsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        try {
            if (gson != null) {
                list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
                }.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 字符串转map
     *
     * @param gsonString json格式的字符串
     * @return 返回map集合
     */
    public <T> Map<String, T> gsonToMap(String gsonString) {
        Map<String, T> map = null;
        try {
            if (gson != null) {
                map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
                }.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
