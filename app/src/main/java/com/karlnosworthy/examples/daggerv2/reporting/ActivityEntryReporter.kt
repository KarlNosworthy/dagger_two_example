package com.karlnosworthy.examples.daggerv2.reporting

import android.app.Activity


class ActivityEntryReporter {

    private var activityEntryStats: MutableMap<String, Int>

    init {
        activityEntryStats = mutableMapOf()
    }

    fun reportActivityEntry(activity: Activity) {

        var activityEntryCount = 0

        val activityName = getActivityName(activity)

        if (activityEntryStats.containsKey(activityName)) {
            activityEntryCount = activityEntryStats[activityName] ?: 0
        }

        activityEntryCount += 1
        activityEntryStats[activityName] = activityEntryCount
    }

    fun getEntryCount(activity: Activity): Int {
        val activityName = getActivityName(activity)
        return activityEntryStats[activityName] ?: 0
    }

    private fun getActivityName(activity: Activity): String {
        return activity::class.java.simpleName
    }
}
