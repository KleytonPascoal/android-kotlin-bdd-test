package com.pascoal.kleyton.android.bdd.test.util

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.pascoal.kleyton.android.bdd.R
import com.pascoal.kleyton.android.bdd.ui.login.LoginActivity
import java.lang.Thread.sleep


class LoginScreenRobot {

    private lateinit var username: String

    fun launchLoginScreen(testRule: ActivityTestRule<LoginActivity>) {
        testRule.launchActivity(null)
    }

    fun selectEmailField() {
        onView(withId(R.id.username)).perform(click())
    }

    fun selectPasswordField() {
        onView(withId(R.id.password)).perform(click())
    }

    fun enterEmail(email: String) {
        this.username = email
        onView(withId(R.id.username)).perform(typeText(email))
    }

    fun enterPassword(password: String) {
        onView(withId(R.id.password)).perform(typeText(password))
    }

    fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
        sleep(100)
    }

    fun clickSignInButton() {
        onView(withText(InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.action_sign_in))).perform(click())
    }

    fun isSuccessfulLogin() {
        onView(withId(R.id.successful_login_msg)).check(matches(isDisplayed()))
        onView(withId(R.id.successful_login_msg)).check(matches(withText(R.string.login_success)))
    }

}