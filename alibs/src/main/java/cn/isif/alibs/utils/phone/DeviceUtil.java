package cn.isif.alibs.utils.phone;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.lang.reflect.Method;

/**
 * 获取设备的一些信息的类
 *
 * @author zh create at 2011-3-18
 */
public class DeviceUtil {

    public static String getProp(String prop) {
        String output = "";
        try {
            Class<?> sp = Class.forName("android.os.SystemProperties");
            Method get = sp.getMethod("get", String.class);
            output = (String) get.invoke(null, prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * 获取IMEI号
     *
     * @param context
     * @return
     */
    public static String getImei(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * 获取屏幕密度
     *
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.density;
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static float getWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static float getHeigh(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    /**
     * 获取分辨率
     *
     * @param context
     * @return
     */
    public static String getResolution(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();
        ApplicationInfo info = context.getApplicationInfo();

        try {
            return manager.getPackageInfo(info.packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    /**
     * 获取版本名称
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        ApplicationInfo info = context.getApplicationInfo();

        try {
            return manager.getPackageInfo(info.packageName, 0).versionName;
        } catch (NameNotFoundException e) {
            return "UnKnow";
        }
    }

}
