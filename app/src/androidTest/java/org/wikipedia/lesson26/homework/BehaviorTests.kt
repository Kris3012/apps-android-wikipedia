package org.wikipedia.lesson26.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.main.MainActivity

class BehaviorTests: TestCase (
    kaspressoBuilder = Kaspresso.Builder.advanced().apply {
        testRunWatcherInterceptors.add(CustomInterceptor())
    }
) {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun simpleTest() {
        before {
            testLogger.i("BEFORE_SECTION_LOG")
        }.after {
            testLogger.i("AFTER_SECTION_LOG")
        }.run {
            testLogger.i("DURING_RUN_LOG")
            step("test1") {
                OnboardingScreenNamed.skipButton.click()
            }
            step("test2") {
                ExploreScreenNamed.items.isDisplayed()
            }
        }

    }
}