package com.karlnosworthy.examples.daggerv2

import com.karlnosworthy.examples.daggerv2.activity.MainActivity
import com.karlnosworthy.examples.daggerv2.activity.OtherActivity

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(otherActivity: OtherActivity)
}
