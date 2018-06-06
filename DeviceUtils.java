package com.dggroup.toptoday.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.dggroup.toptoday.App;

import java.util.Random;

/**
 * Created by malk on 16/8/15.
 */

public class DeviceUtils {

    /**
     * 获得imei码
     *
     * @return
     */
    public static String getIMEI() {
        String id = "";
        Context context = App.getAppContext();
        if (null != context && isHasPermission("android.permission.READ_PHONE_STATE")) {
            id = ((TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        }
        return id;
    }

    /**
     * 判断某个权限是否授权
     *
     * @param permissionName 权限名称，比如：android.permission.READ_PHONE_STATE
     * @return
     */

    public static boolean isHasPermission(String permissionName) {
        Context context = App.getAppContext();

        try {
            PackageManager pm = context.getPackageManager();
            boolean permission = (PackageManager.PERMISSION_GRANTED ==
                    pm.checkPermission(permissionName, context.getPackageName()));

            return permission;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获得android设备id
     *
     * @return
     */
    public static String getAndroidId() {
        String id = "";
        Context appContext = App.getAppContext();
        if (TextUtils.isEmpty(id)) {
            id = Settings.Secure.getString(appContext.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        }
        return id;
    }

    public static boolean hasSIMCard() {
        Context appContext = App.getAppContext();
        TelephonyManager tm = (TelephonyManager) appContext.getSystemService(Context.TELEPHONY_SERVICE);//取得相关系统服务
        return TelephonyManager.SIM_STATE_READY == tm.getSimState();
    }


    /**
     * 获得网络运营商名称
     *
     * @return
     */
    public static String getNetworkOperatorName() {
        String networkOperatorName = "";
        try {
            Context appContext = App.getAppContext();
            TelephonyManager tm = (TelephonyManager) appContext.getSystemService(Context.TELEPHONY_SERVICE);
            networkOperatorName = tm.getNetworkOperatorName();
        } catch (Exception e) {
            networkOperatorName = null;
        }
        return networkOperatorName;
    }

    public static class RandomValidateCode {
        private static final char[] chars = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
                'r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H',
                'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        /**
         * 获得一个随机的字符串 返回Color对象
         * @return
         */
        public static char getRandomCode() {
            Random ran = new Random();
            return chars[ran.nextInt(chars.length)];
        }

        /**
         * 获取干扰字符
         * @param source
         * @param c
         * @return
         */
        public static String getDisturbString(String source,char c) {
            int index=((int)c)%10%3;
            Random ran =null;
            String target=String.valueOf(c)+source;
            for (int i=0;i<index;i++){
                ran=new Random();
                target+=chars[ran.nextInt(chars.length)];
            }
            return target;
        }

    }
}
