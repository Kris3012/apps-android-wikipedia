package org.wikipedia.lesson21.homework

import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.screens.BottomSheetScreen
import org.wikipedia.lesson19.homework.screens.SettingsRecyclerItem
import org.wikipedia.lesson19.homework.screens.SettingsScreen
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson20.homework.extensions.multiAction
import org.wikipedia.lesson21.homework.extensions.invokeAtIndexAndResId
import org.wikipedia.readinglist.recommended.SettingsSection

class SettingsScreenTest: BaseTest() {

    @Test
    fun checkTextForBlockWithCheckbox() {
        run {
            OnboardingScreenNamed.skipButton {
                multiAction()
            }

            ExploreScreenNamed {
                moreMenu.isDisplayed()
                moreMenu.click()
            }

            BottomSheetScreen.settingsButton.click()

            //перешли на экран настроек
            SettingsScreen {
                settingsItems.isDisplayed()
            }

            //выбрать по индексу второй блок с чекбоксом (включить чекбокс и проверить что он включен)

            //но у меня тест падает в этом месте(

            SettingsScreen {
                settingsItems {
                    isDisplayed()
                    invokeAtIndexAndResId<SettingsRecyclerItem>(
                        index = 1,
                        skipItems = 2
                    ) {
                        listItemSwitch.isDisplayed()
                        listItemSwitch.isChecked()

                    }
                }
            }

            //выбрать третий блок с иконкой справа и проверить в нём соответствие текста тому,
            // который в нём реально присутствует.

            SettingsScreen {
                settingsItems {
                    isDisplayed()
                    invokeAtIndexAndResId<SettingsRecyclerItem>(
                        index = 2,
                        skipItems = 0
                    ) {
                        listItemIcon.isDisplayed()
                        listItemTitle.isDisplayed()
                    }
                }
            }


        }
    }
}