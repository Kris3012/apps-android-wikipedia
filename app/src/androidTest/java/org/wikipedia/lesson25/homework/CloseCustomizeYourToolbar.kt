package org.wikipedia.lesson25.homework

import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure

class CloseCustomizeYourToolbar(testContext: BaseTestContext) : ScreenBehaviorBase(testContext) {
    override val step = "Закрывает информер кастомизации тулбара статьи"

    //из файла ScreenBehaviorBase:
    override val action: Allure.StepContext.() -> Unit = {

        getElementByText("Got it").click()
    }


    override fun isConditionMet(): Boolean {
        //из файла ScreenBehaviorBase:
        return checkScreenByText("Got it")
    }
}

