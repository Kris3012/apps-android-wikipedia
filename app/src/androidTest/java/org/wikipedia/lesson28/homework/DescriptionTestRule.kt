package org.wikipedia.lesson28.homework

import org.junit.runner.Description
import org.junit.rules.TestRule
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig

class DescriptionTestRule : TestRule {

    var testData = ""

    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement {
        return object : Statement() {

        override fun evaluate() {
            val description = description?.getAnnotation(io.qameta.allure.kotlin.Description::class.java)

                if (testData.contains("valid")) {
                    BuildConfig.SEARCH_INPUT_VALID
                } else {
                    BuildConfig.SEARCH_INPUT_INVALID
                }
            base?.evaluate()
        }
    }
}
}
