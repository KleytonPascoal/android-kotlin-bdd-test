package com.pascoal.kleyton.android.bdd.test.runner

import cucumber.api.CucumberOptions

@CucumberOptions(glue = ["com.pascoal.kleyton.android.bdd.test.steps"], features = ["features"])
class CucumberOpts {
}