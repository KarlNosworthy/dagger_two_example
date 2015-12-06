package com.karlnosworthy.examples.daggerv2;

import com.karlnosworthy.examples.daggerv2.activity.MainActivity;
import com.karlnosworthy.examples.daggerv2.activity.OtherActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(OtherActivity otherActivity);
}
