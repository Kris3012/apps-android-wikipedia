package org.wikipedia.lesson27.homework

import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson19.homework.tests.BaseTest


class MyTestRuleTests: BaseTest() {

    @Test
    fun SimpleTestOne() = run {
        step("делай раз") {
        }
    }

    @Test
    @Deprecated("Skip test")
    fun SimpleTestTwo() = run {
        step("НЕ делай два") {
        }
    }

    @Test
    fun SimpleTestThree() = run {
        step("делай три") {
        }
    }
}