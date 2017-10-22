package com.bawei.moniceshi;

import android.app.Application;

/**
 * Created by Administrator on 2017/10/23.
 */

public class CrashApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}
