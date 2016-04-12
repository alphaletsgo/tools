package cn.isif.alibs.utils.io;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.isif.alibs.utils.EncodingUtils;

/**
 * android system file/directory option
 * <p>
 * Created by zh on 15/7/5.
 */
public class OsFileUtils {


    /**
     * read file in /sdcard/
     *
     * @param fileName
     * @return
     */
    public static String readFileSdcard(String fileName) {
        String res = "";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            res = EncodingUtils.getString(buffer, "UTF-8");
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * write file to /sdcard/
     *
     * @param fileName
     * @param message
     * @param append
     */
    public static void writeFileSdcard(String fileName, String message, boolean append) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(fileName, append);
            byte[] bytes = message.getBytes();
            fout.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * get file in asset
     *
     * @param fileName
     * @param c
     * @return
     */
    public static String getFromAssets(String fileName, Context c) {
        String result = "";
        try {
            InputStream in = c.getResources().getAssets().open(fileName);
            // 获取文件的字节数
            int lenght = in.available();
            // 创建byte数组
            byte[] buffer = new byte[lenght];
            // 将文件中的数据读到byte数组中
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString().trim();
    }
}
