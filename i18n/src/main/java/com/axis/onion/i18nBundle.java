package com.axis.onion;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by qingyuan on 2018/10/23.
 */
public class i18nBundle {

    private static ResourceBundle bundle;

    static {
        //取得系统默认的国家／语言环境
        Locale locale = Locale.getDefault(Locale.Category.FORMAT);
        //根据指定的国家／语言环境加载资源文件
        bundle = ResourceBundle.getBundle("message-source", locale);
    }

    /**
     * 没有占位符
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        return getMessage(key, null);
    }

    /**
     * 有占位符
     * @param key
     * @param placeholder
     * @return
     */
    public static String getMessage(String key, Object... placeholder) {
        String msg = bundle.getString(key);
        if (null != placeholder && placeholder.length > 0)
            return MessageFormat.format(msg, placeholder);
        else
            return bundle.getString(key);
    }

    public static void main(String[] args) {
        System.out.print(i18nBundle.getMessage("MAMM01","123"));
    }
}
