package cn.isif.alibs.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Preference 读写封装
 *
 * Created by zh on 15/7/5.
 */
public class SharePreferenceUtils {
    public SharePreferenceUtils() {
    }

    public static void write(String fileName, String k, int v) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public static void write(String fileName, String k, boolean v) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public static void write(String fileName, String k, String v) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public static int readInt(String fileName, String k) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        return preference.getInt(k, 0);
    }

    public static int readInt(String fileName, String k, int defv) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        return preference.getInt(k, defv);
    }

    public static boolean readBoolean(String fileName, String k) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        return preference.getBoolean(k, false);
    }

    public static boolean readBoolean(String fileName, String k, boolean defBool) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        return preference.getBoolean(k, defBool);
    }

    public static String readString(String fileName, String k) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        return preference.getString(k, (String) null);
    }

    public static String readString(String fileName, String k, String defV) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        return preference.getString(k, defV);
    }

    public static void remove(String fileName, String k) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void clean(String fileName) {
        SharedPreferences preference = ALibs.getApp().getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }
}
