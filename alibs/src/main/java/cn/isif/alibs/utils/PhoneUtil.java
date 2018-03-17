package cn.isif.alibs.utils;


/**
 * 获取手机信息
 *
 * Created by zhy on 2015/2/6.
 */
public class PhoneUtil {
    public static final String SYSTEM_NAME = "Android";

    /**
     * 获取手机的品牌
     *
     * DeviceUtil@return
     */
    public static String getPhoneBrand() {
        return android.os.Build.MANUFACTURER;
    }

    /**
     * 获取手机的型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机系统版本
     *
     * @return
     */
    public static String getVersionWithPhone() {
        return android.os.Build.VERSION.RELEASE;
    }


}
