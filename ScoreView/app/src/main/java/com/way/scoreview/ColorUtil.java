package com.way.scoreview;

import android.graphics.Color;

import java.util.regex.Pattern;

/**
 * Created by pc on 2016/7/10.
 */
public class ColorUtil {
    /**
     * 获取资源中的颜色转换成16进制
     * @param colorid
     * @return
     */
    public static int getResourcesColor(int colorid) {
        int ret = 0x00ffffff;
        try {
            ret = MyApp.getContext().getResources().getColor(colorid);
        } catch (Exception e) {
        }
        return ret;
    }

    /**
     * 将十六进制 颜色代码 转换为 int
     *
     * @return
     */
    public static int HextoColor(String color) {
        // #ff00CCFF
        String reg = "#[a-f0-9A-F]{8}";
        if (!Pattern.matches(reg, color)) {
            color = "#00ffffff";
        }
        return Color.parseColor(color);
    }

    /**
     * 修改颜色透明度
     * @param color
     * @param alpha
     * @return
     */
    public static int changeAlpha(int color, int alpha) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
