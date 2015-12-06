package com.karlnosworthy.examples.daggerv2;

import com.karlnosworthy.examples.daggerv2.activity.OtherActivity;
import com.karlnosworthy.examples.daggerv2.activity.MainActivity;
import com.karlnosworthy.examples.daggerv2.reporting.ActivityEntryReporter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    public ApplicationModule() {
        super();
    }

    @Singleton
    @Provides
    public ActivityEntryReporter providesActivityEntryReporter() {
        return new ActivityEntryReporter();
    }
}
