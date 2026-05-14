package org.wikipedia.lesson19.homework.tests


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.lesson27.homework.DeprecatedTestRule
import org.wikipedia.lesson27.homework.ExampleRules
import org.wikipedia.main.MainActivity

abstract class BaseTest: TestCase(
    Kaspresso.Builder.withForcedAllureSupport().apply {
        ComposeConfig.Builder.default(this) {} }
) {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    //урок 27. Добавим сюда свой кастомный rule
//    @get:Rule
//    val baseRule = ExampleRules()

// дз. Добавила свой рул
    @get:Rule
    val myRule = DeprecatedTestRule()




}