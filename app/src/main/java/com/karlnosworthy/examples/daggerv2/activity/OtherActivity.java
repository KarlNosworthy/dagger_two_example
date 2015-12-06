package com.karlnosworthy.examples.daggerv2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.karlnosworthy.examples.daggerv2.ApplicationImpl;
import com.karlnosworthy.examples.daggerv2.R;
import com.karlnosworthy.examples.daggerv2.reporting.ActivityEntryReporter;

import javax.inject.Inject;


public class OtherActivity extends Activity {

    @Inject
    ActivityEntryReporter activityEntryReporter;

    private TextView entryCountTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        // Inject our required instances from the centralised Dagger
        // object graph
        ApplicationImpl.using(this).inject(this);

        // now that we've had our instances injected, we can use them
        activityEntryReporter.reportActivityEntry(this);

        // Never do this, use ButterKnife! but for the purposes of keeping this
        // example simple..
        entryCountTextView = (TextView) findViewById(R.id.other_entry_count_text_view);

    }

    @Override
    protected void onResume() {
        super.onResume();

        int entryCount = activityEntryReporter.getEntryCount(this);

        String entryCountText = getResources().getQuantityString(R.plurals.other_activity_has_been_entered,
                                                                 entryCount,
                                                                 entryCount);

        entryCountTextView.setText(entryCountText);
    }
}
