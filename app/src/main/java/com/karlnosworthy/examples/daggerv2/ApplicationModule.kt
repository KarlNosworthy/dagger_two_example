package com.karlnosworthy.examples.daggerv2

import com.karlnosworthy.examples.daggerv2.reporting.ActivityEntryReporter

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun providesActivityEntryReporter(): ActivityEntryReporter {
        return ActivityEntryReporter()
    }
}
