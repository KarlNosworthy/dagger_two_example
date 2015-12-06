package com.karlnosworthy.examples.daggerv2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.karlnosworthy.examples.daggerv2.ApplicationImpl;
import com.karlnosworthy.examples.daggerv2.R;
import com.karlnosworthy.examples.daggerv2.reporting.ActivityEntryReporter;

import javax.inject.Inject;


public class MainActivity extends Activity {

    @Inject
    ActivityEntryReporter activityEntryReporter;

    private TextView entryCountTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inject our required instances from the centralised Dagger
        // object graph
        ApplicationImpl.using(this).inject(this);


        // Never do this, use ButterKnife! but for the purposes of keeping this
        // example simple..
        entryCountTextView = (TextView) findViewById(R.id.main_entry_count_text_view);

        Button launchOtherActivityButton = (Button) findViewById(R.id.launch_other_activity_button);
        launchOtherActivityButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        activityEntryReporter.reportActivityEntry(this);

        int entryCount = activityEntryReporter.getEntryCount(this);

        String entryCountText = getResources().getQuantityString(R.plurals.main_activity_has_been_entered,
                                                                 entryCount,
                                                                 entryCount);

        entryCountTextView.setText(entryCountText);
    }
}
