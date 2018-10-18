package com.karlnosworthy.examples.daggerv2.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

import com.karlnosworthy.examples.daggerv2.ApplicationImpl
import com.karlnosworthy.examples.daggerv2.R
import com.karlnosworthy.examples.daggerv2.reporting.ActivityEntryReporter
import kotlinx.android.synthetic.main.activity_other.*

import javax.inject.Inject

 class OtherActivity : Activity() {

    @Inject
    lateinit var reportActivityEntry: ActivityEntryReporter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        // Inject our required instances from the centralised Dagger
        // object graph
        ApplicationImpl.using(this).inject(this)

        // now that we've had our instances injected, we can use them
        reportActivityEntry.reportActivityEntry(this)

    }

    override fun onResume() {
        super.onResume()

        val entryCount = reportActivityEntry.getEntryCount(this)

        val entryCountText = resources.getQuantityString(R.plurals.other_activity_has_been_entered,
                                                                 entryCount,
                                                                 entryCount)
         other_entry_count_text_view.text = entryCountText
    }
}
