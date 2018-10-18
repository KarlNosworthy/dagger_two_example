package com.karlnosworthy.examples.daggerv2

import android.app.Application
import android.content.Context


class ApplicationImpl : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .build()
    }

    companion object {
        fun using(context: Context): ApplicationComponent {
            return (context.applicationContext as ApplicationImpl).applicationComponent
        }
    }
}
