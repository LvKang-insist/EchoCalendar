package com.echo.calendar;

import android.app.Application;

/**
 * BaseApplication
 */
public class BaseApplication extends Application {
    public static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
