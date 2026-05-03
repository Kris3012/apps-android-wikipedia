package org.wikipedia.lesson24.homework.tests

import androidx.compose.ui.test.ExperimentalTestApi
import org.junit.Test
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson19.homework.utils.action
import org.wikipedia.lesson19.homework.utils.verify
import org.wikipedia.lesson24.homework.screens.AddLanguageScreen
import org.wikipedia.lesson24.homework.screens.LanguageItem
import org.wikipedia.lesson24.homework.screens.WikipediaLanguagesScreen

class AddLanguageTest : BaseTest() {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun addLanguageTest() {
        run {
            // Онбординг - нажать Add language
            OnboardingScreenNamed.page(0) {
                action.click(addLanguageButton)
            }
            // XML экран - выбрать блок Add language
            WikipediaLanguagesScreen{
                action.click(wikiLanguageTitle)
            }

            // Compose экран - проверить текст и добавить язык по индексу

                //на этом шаге мой тест падает, не удалось пока решить проблему
            AddLanguageScreen.items {
                childAt<LanguageItem>(3) {
                    verify.assertTrimmedTextIsEquals(localizedText, "Japanese")
                    verify.assertTrimmedTextIsEquals(canonicalText, "日本語")
                }
                action.clickIfEnabled(this)
            }

            device.uiDevice.pressBack()

            // Онбординг - проверить, что язык добавился
            OnboardingScreenNamed.page(0) {
                verify.hasText(languageLabel, "日本語")
            }
        }

    }
}

