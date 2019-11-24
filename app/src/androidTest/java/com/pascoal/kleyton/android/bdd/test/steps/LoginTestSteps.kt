package com.pascoal.kleyton.android.bdd.test.steps

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.pascoal.kleyton.android.bdd.test.util.ActivityFinisher
import com.pascoal.kleyton.android.bdd.test.util.LoginScreenRobot
import com.pascoal.kleyton.android.bdd.ui.login.LoginActivity
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.runner.RunWith


@SuppressWarnings("JUnitTestCaseWithNoTests")
@RunWith(AndroidJUnit4::class)
class LoginTestSteps {

    private val robot = LoginScreenRobot()

    private val activityRule = ActivityTestRule(LoginActivity::class.java, false, false)

    @Before
    fun setup() {
        //not needed now, but you may needed to setup mock responses before your screen starts
    }

    @After
    fun tearDown() {
        ActivityFinisher.finishOpenActivities() // Required for test scenarios with multiple activities or scenarios with more cases
    }

    @Given("^I start the application$")
    fun i_start_app() {
        robot.launchLoginScreen(activityRule)
    }

    @When("^I click email field$")
    fun i_click_email_field() {
        robot.selectEmailField()
    }

    @And("^I close the keyboard$")
    fun i_close_the_keyboard() {
        robot.closeKeyboard()
    }

    @And("^I enter valid email (\\S+)$")
    fun i_enter_valid_email(email: String) {
        robot.enterEmail(email)
    }

    @And("^I click password field$")
    fun i_click_password_field() {
        robot.selectPasswordField()
    }

    @And("^I enter valid password (\\S+)$")
    fun i_enter_valid_password(password: String) {
        robot.enterPassword(password)
    }

    @And("^I click sign in button$")
    fun i_click_sign_in_button() {
        robot.clickSignInButton()
    }

    @Then("^I expect to see successful login message$")
    fun i_expect_to_see_successful_login_message() {
        robot.isSuccessfulLogin()
    }

}

/*
@RunWith(AndroidJUnit4::class)
class Feature01Steps {

    @Rule
    var mActivityTestRule: ActivityTestRule<MoviesActivity> =
        ActivityTestRule(MoviesActivity::class.java, true, false)

    private var mCurrentPage: BasePage? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        removeMoviesFromDatabase()
        insertMoviesInDatabase()
        mActivityTestRule.launchActivity(Intent())
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        ActivityFinisher.finishOpenActivities()
        removeMoviesFromDatabase()
    }

    @Given("^I see My Movies page - F01$")
    @Throws(Exception::class)
    fun i_see_my_movies_page() {
        mCurrentPage = MoviesPage()
    }

    @When("^I select navigation bottom to show movie as carousel")
    fun i_select_navigation_bottom_to_show_movie_as_carousel() {
        mCurrentPage!!.`is`(MoviesPage::class.java).actionShowMoviesAsCarousel()
    }

    @Then("^I want to see my movies saved as carousel")
    fun i_want_to_see_my_movies_saved_as_carousel() {
        mCurrentPage!!.`is`(MoviesPage::class.java).checkMoviesShowAsCarousel()
    }

    @When("^I select navigation bottom to show movie as list")
    fun i_select_navigation_bottom_to_show_movie_as_list() {
        mCurrentPage!!.`is`(MoviesPage::class.java).actionShowMoviesAsList()
    }

    @Then("^I want to see my movies saved as list")
    fun i_want_to_see_my_movies_saved_as_list() {
        mCurrentPage!!.`is`(MoviesPage::class.java).checkMoviesShowAsList()
    }

    @When("^I select navigation bottom to show movie as grid")
    fun i_select_navigation_bottom_to_show_movie_as_grid() {
        mCurrentPage!!.`is`(MoviesPage::class.java).actionShowMoviesAsGrid()
    }

    @Then("^I want to see my movies saved as grid")
    fun i_want_to_see_my_movies_saved_as_grid() {
        mCurrentPage!!.`is`(MoviesPage::class.java).checkMoviesShowAsGrid()
    }

    @When("^I swipe to right my movies grid")
    fun i_swipe_to_right_my_movies_grid() {
        mCurrentPage!!.`is`(MoviesPage::class.java).actionSwipeToRight()
    }

    @Then("^I want to see my movies as list again")
    fun i_want_to_see_my_movies_saved_as_list_again() {
        mCurrentPage!!.`is`(MoviesPage::class.java).checkMoviesShowAsList()
    }

    @When("^I swipe to right my movies list")
    fun i_swipe_to_right_my_movies_list() {
        mCurrentPage!!.`is`(MoviesPage::class.java).actionSwipeToRight()
    }

    @Then("^I want to see my movies as carousel again")
    @Throws(Exception::class)
    fun i_want_to_see_my_movies_saved_as_carousel_again() {
        mCurrentPage!!.`is`(MoviesPage::class.java).checkMoviesShowAsCarousel()
    }
}*/
