package org.wikipedia.lesson25.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson19.homework.utils.action
import org.wikipedia.lesson19.homework.utils.verify

class SmartScenariosTest : BaseTest() {


    @Test
    fun closeInformerTest() {
        run {
            action.click(OnboardingScreenNamed.skipButton)


            ExploreScreenNamed {
                featuredArticleBlock {
                    verify.isDisplayed(this)
                    action.click(featuredArticleTitle)
                }
            }
        }

    }
}
