package org.wikipedia.lesson09.homework

import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.lesson03.homework.OnboardingScreen.invoke
import org.wikipedia.lesson03.homework.OnboardingScreen.skipButton
import org.wikipedia.lesson08.homework.CustomizeItem
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson09.homework.CustomizeScreen.backButton
import org.wikipedia.main.MainActivity

class ExploreTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkExploreScreen() {
        run("Отображение экрана Explore") {
            step("Проверяет, что кнопка Skip на онбординге отображается") {
                OnboardingScreen {
                    skipButton.isDisplayed()
                }
            }
            step("Нажимает кнопку Skip на экране онбординга") {
                OnboardingScreen {
                    skipButton.click()
                }
            }
            step("Проверяет отображение блока Featured Article на экране Explore") {
                ExploreScreen.items {
                    childWith<FeaturedArticleItem> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        featuredMenuIcon.isDisplayed()
                    }
                }
                step("Нажимает на кнопку Customize экрана Explore") {
                    ExploreScreen.items.childWith<CustomizeItem> {
                    } perform {
                        customizeButton.click()
                    }
                }
                step("Отключает Featured Article на экране Customize") {
                    CustomizeScreen.items.childWith<CustomizeFeedItem> {
                        withDescendant {
                            withText("Featured article")
                        }
                    } perform {
                        featuredSwitcher.click()
                    }

                }
            }
            step("Нажимает стрелку назад в верхнем тулбаре") {
                backButton.click()
            }
            step("Проверяет, что блок Featured Article не отображается на экране Explore") {
                // скроллим вверх, чтоб обновить экран и убрать проверяемый блок
                // ExploreScreen.items.scrollTo(0)

                ExploreScreen.items.childWith<FeaturedArticleItem> {
                    withDescendant {
                        withText("Featured Article")
                    }
                    doesNotExist()
                }
            }
        }
    }
}



