package com.example.cxf.practicedemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cxf on 2018年4月19日14:37:01
 * 首选项存取工具类
 */
public class PreferenceUtil {

    //存储的sharedpreferences文件名
    private static final String FILE_NAME = "sharedpreferences_name";

    private static SharedPreferences preferences = null;

    private PreferenceUtil() {
        //
    }
//    /**
//     * @param context
//     * @param isface  强制初始化
//     */
//    public static void initialize(Context context, boolean isface) {
//        if (preferences == null || isface) {
//            preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
//        }
//    }
//
//    public static void initialize(Context context) {
//        initialize(context, false);
//    }

    public static SharedPreferences getPreference() {
        return preferences;
    }

    /**
     * 保存Sring型数据
     *
     * @param key   键
     * @param value 数值
     */
    public static void setStringValue(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 保存int型数据
     *
     * @param key   键
     * @param value 数值
     */
    public static void setIntValue(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * 保存int型数据
     *
     * @param key   键
     * @param value 数值
     */
    public static void setLongValue(String key, Long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 保存Boolean型数据
     *
     * @param key   键
     * @param value 数值
     */
    public static void setBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 获取String类型数据
     *
     * @param key          键
     * @param defaultValue 数值
     * @return String类型数据
     */
    public static String getString(String key, String defaultValue) {
        if (preferences == null) {
            return "";
        }
        return preferences.getString(key, defaultValue);
    }

    /**
     * 获取Int类型数据
     *
     * @param key          键
     * @param defaultValue
     * @return Int类型数据
     */
    public static int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public static long getLong(String key, Long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    /**
     * 获取Boolean类型数据
     *
     * @param key          键
     * @param defaultValue
     * @return Boolean类型数据
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }


    /**
     * 除清首选项数据
     *
     * @param context 界面上下文
     */
    public static void clearData(Context context) {
        preferences.edit().clear().commit();
    }

    /**
     * 是否存在key键值
     *
     * @param key 键
     * @return 是否存在
     */
    public static boolean contains(String key) {
        return preferences.contains(key);
    }
}

