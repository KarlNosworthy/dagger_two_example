package com.karlnosworthy.examples.daggerv2.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import com.karlnosworthy.examples.daggerv2.ApplicationImpl
import com.karlnosworthy.examples.daggerv2.R
import com.karlnosworthy.examples.daggerv2.reporting.ActivityEntryReporter
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject


class MainActivity : Activity() {

    @Inject
    lateinit var activityEntryReporter: ActivityEntryReporter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inject our required instances from the centralised Dagger
        // object graph
        ApplicationImpl.using(this).inject(this)

        launch_other_activity_button.setOnClickListener{ _ ->
                startActivity(Intent(this@MainActivity, OtherActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        activityEntryReporter.reportActivityEntry(this)

        val entryCount = activityEntryReporter.getEntryCount(this)

        val entryCountText = resources.getQuantityString(R.plurals.main_activity_has_been_entered,
                                                                 entryCount,
                                                                 entryCount)

        main_entry_count_text_view.text = entryCountText
    }
}
