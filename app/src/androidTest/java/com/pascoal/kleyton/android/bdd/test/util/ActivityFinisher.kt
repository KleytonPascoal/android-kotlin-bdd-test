package com.pascoal.kleyton.android.bdd.test.util

import android.app.Activity
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage

class ActivityFinisher private constructor() : Runnable {

    private val activityLifecycleMonitor: ActivityLifecycleMonitor =
        ActivityLifecycleMonitorRegistry.getInstance()

    override fun run() {
        val activities: MutableList<Activity> = emptyList<Activity>().toMutableList()

        val stages = arrayOf<Stage>(
            Stage.CREATED,
            Stage.STOPPED,
            Stage.PAUSED,
            Stage.STARTED,
            Stage.RESUMED,
            Stage.RESTARTED,
            Stage.PRE_ON_CREATE
        )

        for (stage in stages) {
            activities.addAll(activityLifecycleMonitor.getActivitiesInStage(stage))
        }

        for (activity in activities) {
            InstrumentationRegistry.getInstrumentation().callActivityOnStop(activity)
            if (!activity.isFinishing()) {
                activity.finish()
            }
        }


    }

    companion object {

        fun finishOpenActivities() {
            InstrumentationRegistry.getInstrumentation().runOnMainSync(ActivityFinisher())
        }
    }
}