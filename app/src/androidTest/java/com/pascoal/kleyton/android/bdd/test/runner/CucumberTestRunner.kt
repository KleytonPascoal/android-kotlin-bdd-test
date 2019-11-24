package com.pascoal.kleyton.android.bdd.test.runner

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import cucumber.api.android.CucumberInstrumentationCore


class CucumberTestRunner : AndroidJUnitRunner() {

    private val instrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle) {
        instrumentationCore.create(arguments)
        super.onCreate(arguments)
    }

    override fun onStart() {
        waitForIdleSync()
        instrumentationCore.start()
        super.onStart()
    }
}