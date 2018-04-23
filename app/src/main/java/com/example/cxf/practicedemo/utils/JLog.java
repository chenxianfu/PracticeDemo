package com.example.cxf.practicedemo.utils;

import android.util.Log;

import com.example.cxf.practicedemo.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by dell on 2015/5/7.
 */
public class JLog {
    private static final boolean DEBUG = Config.DEBUG;

    public static void e(String tag, String message) {
        if (DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (DEBUG) {
            Log.i(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (DEBUG) {
            Log.w(tag, message);
        }
    }

    public static void wtf(String tag, String message) {
        if (DEBUG) {
            Log.wtf(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (DEBUG) {
            Log.v(tag, message);
        }
    }

    public static void jsonD(String tag, String message, Object obj) {
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(new Gson().toJson(obj));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JLog.d(tag, message + " \n " + gson.toJson(je));
    }
}
