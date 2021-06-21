package com.example.rxjava.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON序列化辅助类
 **/
public class JSONUtils {
    private static Gson gson;

    private JSONUtils() {
    }

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    public static String toJSON(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObj(String json, Class<T> clz) {
        return toObj(json, clz, true);
    }

    public static <T> T toObj(String json, Class<T> clz, boolean needReport) {
        try {
            return gson.fromJson(json, clz);
        } catch (Exception e) {
            if (!filterWifiAuthError(json)) {
                String s = "json error \n" + json + "\n" + e.getCause();
//                if (needReport)
//                    MobclickAgent.reportError(App.get(), s);
            }
            e.printStackTrace();
        }
        return null;
    }

    //add by xujian
    public static <T> T toObj(String json, Type type) {
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toListObj(String str, Class<T> type) {
        ArrayList<T> list = new ArrayList<>();
        JsonParser parser = new JsonParser();
        try {
            JsonArray jarray = parser.parse(str).getAsJsonArray();
            for (JsonElement obj : jarray) {
                T item = gson.fromJson(obj, type);
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 筛选出wifi验证的内容返回
     */
    private static boolean filterWifiAuthError(String json) {
        if (TextUtils.isEmpty(json) || json.length() < 10)
            return false;
        json = json.toLowerCase();
        return json.contains("<!doctype") || json.contains("portal") ||
                json.contains("wifi") || json.contains("location.href");
    }

    public static class Builder extends JSONObject {
        @Override
        public JSONObject put(String name, Object value) throws JSONException {
            if (value == null) {
                return super.put(name, "");
            }
            if (value instanceof String) {
                return super.put(name, value.toString());
            }
            return super.put(name, value);
        }
    }

    public static int getInt(String data, String key) {
        try {
            return new JSONObject(data).getInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static double getDouble(String data, String key) {
        try {
            return new JSONObject(data).getDouble(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long getLong(String data, String key) {
        try {
            return new JSONObject(data).getLong(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean getBoolean(String data, String key) {
        try {
            return new JSONObject(data).getBoolean(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getString(String data, String key) {
        try {
            return new JSONObject(data).getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

}
