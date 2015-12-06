package com.karlnosworthy.examples.daggerv2.reporting;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;


public class ActivityEntryReporter {

    private Map<String, Integer> activityEntryStats;


    public ActivityEntryReporter() {
        super();
        this.activityEntryStats = new HashMap<>();
    }

    public void reportActivityEntry(Activity activity) {

        int activityEntryCount = 0;

        String activityName = getActivityName(activity);

        if (activityEntryStats.containsKey(activityName)) {
            activityEntryCount = activityEntryStats.get(activityName);
        }

        activityEntryCount += 1;
        activityEntryStats.put(activityName, activityEntryCount);
    }

    public Integer getEntryCount(Activity activity) {
        String activityName = getActivityName(activity);

        if (activityEntryStats.containsKey(activityName)) {
            return activityEntryStats.get(activityName);
        } else {
            return 0;
        }
    }

    private String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }
}
