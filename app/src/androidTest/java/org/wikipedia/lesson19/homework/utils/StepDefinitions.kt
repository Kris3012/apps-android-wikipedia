package org.wikipedia.lesson19.homework.utils

import com.kaspersky.components.composesupport.core.actions.KNodeActions
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.homework.extensions.getName
import org.wikipedia.lesson23.homework.utils.KWebViewElement
import org.wikipedia.lesson24.homework.utils.assertTrimmedTextIsEquals
import org.wikipedia.lesson24.homework.utils.clickIfEnabled
import org.wikipedia.lesson25.homework.CloseCustomizeYourToolbar
import org.wikipedia.lesson25.homework.ClosePlayTodayGame
import org.wikipedia.lesson25.homework.PassInterferingScreens

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun scrollTo(step: String, element: BaseActions) {
        execute(step) {
            element.scrollTo()
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }


    // кастомный элемент для проверки видимости вебвью элементов, урок 23
    fun isDisplayed(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                scroll()
            }
        }
    }

    // дз урок 23
    fun click(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                click()
            }
        }
    }

    fun hasText(step: String, element: KWebViewElement, text: String) {
        execute(step) {
            element.performWebViewAction {
                hasText(text)
            }
        }
    }

    //урок 24
    // шаг 1. имортировали сюда экшен из NodeActionsExt
    fun clickIfEnabled(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
        }
    }

    //а сюда - assertions из TrimmedTextAssertions
    fun assertTrimmedTextIsEquals(step: String, element: NodeAssertions, expected: String) {
        execute(step) {
            element.assertTrimmedTextIsEquals(expected)
        }
    }

    fun step(description: String, block: () -> Unit) {
        execute(description, block)
    }


    //урок 25.
// передаем тут список смарт-сценариев
    private val passInterferingScreens = PassInterferingScreens(
        listOf(
            ClosePlayTodayGame(testContext),
            //добавили свежий смарт-сценарий:
            CloseCustomizeYourToolbar(testContext)
        )
    )
// далее пользуемся этим списком тут -
    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            try {
                fnc()
            } catch (_: Throwable) {
                passInterferingScreens.execute()
                fnc()
            }
        }
    }

}
