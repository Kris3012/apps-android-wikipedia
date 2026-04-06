package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.main.MainActivity

class OnboardingAllureTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport(false)){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickSkipButtonOnOnboardingScreen() {
        run() {
            OnboardingScreen {
                step("Проверяет, что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
                step("Нажимает кнопку Skip на экране онбординга") {
                    skipButton.click()

                }
            }
        }

    }

    @Test
    fun checkExploreScreenFail() {
        run("Отображение экрана Explore") {
            step("Проверяет отображение блока Featured Article на экране Explore") {
                ExploreScreen.items {
                    childWith<FeaturedArticleItem> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        featuredMenuIcon.isDisplayed()
                    }
                }
            }

        }
    }
}
