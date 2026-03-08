package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiScreenTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingUiScreenOne() {
        run {
            step("Проверяет, что находится на 1м слайде"){
                OnboardingUiScreen{
                    primaryHeader.containsText("Encyclopedia")
                }
            }
        }
    }
    @Test
    fun checkOnboardingUiScreenTwo() {
        run {
            step("Переход на второй слайд") {
                OnboardingUiScreen {
                    continueButton.click()
                }
            }
            step("Проверяет текст второго слайда") {
                OnboardingUiScreen {
                    primaryHeader.containsText("New ways")
                }
            }
        }
    }
    @Test
    fun checkOnboardingUiScreenThree() {
        run {
            step("Переход на второй слайд") {
                OnboardingUiScreen { continueButton.click() }
            }
            step("Переход на третий слайд") {
                OnboardingUiScreen { continueButton.click() }
            }
            step("Проверяет текст третьего слайда") {
                OnboardingUiScreen {
                    primaryHeader.containsText("Reading lists")
                }
            }
        }
    }
    @Test
    fun checkOnboardingUiScreenFour() {
        run {
            step("Переход на второй") {
                OnboardingUiScreen { continueButton.click() }
            }
            step("Переход на третий") {
                OnboardingUiScreen { continueButton.click() }
            }
            step("Переход на четвертый") {
                OnboardingUiScreen { continueButton.click() }
            }
            step("Проверяет текст четвертого слайда") {
                OnboardingUiScreen {
                    primaryHeader.containsText("Data")
                }
            }
        }
    }
}