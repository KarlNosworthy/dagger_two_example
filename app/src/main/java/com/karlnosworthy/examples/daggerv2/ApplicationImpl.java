package com.karlnosworthy.examples.daggerv2;

import android.app.Application;
import android.content.Context;


public class ApplicationImpl extends Application {

    private ApplicationComponent applicationComponent;


    public static ApplicationComponent using(Context context) {
        return ((ApplicationImpl) context.getApplicationContext()).getApplicationComponent();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .build();
    }

    private ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
