package cn.isif.alibs.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by le on 2018/3/17.
 */

public class ALibs {
    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;

    /**
     * Init utils.
     * <p>Init it in the class of Application.</p>
     *
     * @param context context
     */
    public static void init(@NonNull final Context context) {
        sApplication = (Application) context.getApplicationContext();
    }

    /**
     * Return the context of Application object.
     *
     * @return the context of Application object
     */
    public static Application getApp() {
        if (sApplication != null) return sApplication;
        throw new NullPointerException("u should init first");
    }
}
