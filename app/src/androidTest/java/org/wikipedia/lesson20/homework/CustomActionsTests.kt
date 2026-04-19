package org.wikipedia.lesson20.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.screens.BottomSheetScreen
import org.wikipedia.lesson19.homework.screens.SettingsScreen
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson19.homework.utils.action
import org.wikipedia.lesson19.homework.utils.verify
import org.wikipedia.lesson20.homework.extensions.equalsWithTrim
import org.wikipedia.lesson20.homework.extensions.multiAction

class CustomActionsTests : BaseTest() {


    @Test
    fun customActionsTest() {
        run {
            //Пропускаешь онбординг методом multiAction()
            OnboardingScreenNamed.skipButton {
                multiAction()
            }

            ExploreScreenNamed.searchMenu.isDisplayed()

            //Переходишь на экран поиска
            //Кликаешь по полю поиска
            ExploreScreenNamed.searchMenu.click()
            ExploreScreenNamed.searchMenu.click()

            SearchScreen.searchInput.isDisplayed()


            //Выполняешь к полю поиска метод multiAction() и проверяешь что оно заполнилось соответствующим значением
            SearchScreen.searchInput {
                click()
                multiAction()
            }


            //Переходишь назад через физическую кнопку back
            repeat(2) {
                device.uiDevice.pressBack()
            }

            //Открываешь меню More
            //Переходишь в пункт Settings
            ExploreScreenNamed{
                moreMenu.isDisplayed()
                moreMenu.click()
            }
            BottomSheetScreen.settingsButton.click()

            //Включаешь свитчер "Download only over Wi-Fi" методом multiAction()
            //Проверяешь что свитчер включен
            SettingsScreen.settingItemWithTitle("Download only over Wi-Fi") {
                listItemSwitch.multiAction()
                listItemSwitch.isChecked()
            }


        }
    }

}