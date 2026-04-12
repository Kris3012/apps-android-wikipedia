package org.wikipedia.lesson19.homework.tests

import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson18.homework.TopReadItemNamed
import org.wikipedia.lesson18.homework.TopReadRecyclerNamed
import org.wikipedia.lesson18.homework.extensions.invokeAtIndex
import org.wikipedia.lesson18.homework.extensions.invokeWithText
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson18.homework.TopReadCardNamed

class ExploreScreenTests : BaseTest() {

    //Переход на Explore -> Top Read -> проверить отображение картинки в третьем блоке
    @Test
    fun CheckThirdImageInTheList() {
        run {
            action.click(OnboardingScreenNamed.skipButton)

            ExploreScreenNamed.items.invokeWithText<TopReadCardNamed>("Top read") {

                topReadItems.childAt<TopReadRecyclerNamed>(2) {
                    verify.isDisplayed(listItemImage)
                }
            }
        }
    }

//Переход на Explore -> нижнее меню More -> settings -> выключить Show link previews -> проверить что тогл выключен.

    //пока не приступала
}