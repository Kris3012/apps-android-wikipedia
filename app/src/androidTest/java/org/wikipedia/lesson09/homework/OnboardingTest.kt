package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class OnboardingTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    // этот тест отдельно от тестов Explore
    @Test
    fun clickSkipButtonOnOnboardingScreen() {
        run() {
            OnboardingScreen {
                step("Проверяет, что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
                step("Нажимает кнопку Skip на экране онбординга") {
                    skipButton.click()

                }
            }
        }

    }
}