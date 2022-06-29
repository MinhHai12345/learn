package com.minhhai.learn.common.context;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class CommonResourceBundle {
    private static CommonResourceBundle instance = new CommonResourceBundle();
    private ResourceBundle bundle;

    public static CommonResourceBundle getInstance() {
        return instance;
    }

    private CommonResourceBundle() {
        bundle = ResourceBundle.getBundle("i18n.messages", new Locale("vi"));
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public static String getMessage(String key) {
        return getInstance().getBundle().getString(key);
    }

    public static String getMessage(String key, Object... params) {
        return MessageFormat.format(getInstance().getBundle().getString(key), params);
    }
}
