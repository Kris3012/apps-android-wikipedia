package org.wikipedia.lesson13.homework


import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.views.KView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson09.homework.FeaturedArticleItem
import org.wikipedia.main.MainActivity

class ArticleTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun articleTest() {
        run {

            step("Переходит на экран Explore, скипнув онбординг") {
                OnboardingScreen {
                    skipButton.click()
                }
            }

            step("Переходит внутрь статьи блока Featured Article") {
                ExploreScreen.items {
                    childWith<FeaturedArticleItem> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        articleCard {
                            scrollTo()
                            click()
                        }
                    }
                }
            }

            step("Закрывает popup") {
                flakySafely(timeoutMs = 5000) {
                    device.uiDevice.pressBack()
                }
            }
            step("Закрывает popup Play today's game") {
                flakySafely(timeoutMs = 5000) {
                    KView {
                        withContentDescription("Close")
                    }.click()
                }
            }
            step("Ждёт открытия статьи") {
                flakySafely(timeoutMs = 10000) {
                    ArticleScreen.webView {
                        withElement(Locator.TAG_NAME, "body") {
                            isDisplayed()
                        }
                    }
                }
            }

            step("Скроллит до элемента с id References") {
                flakySafely(timeoutMs = 15000) {
                    ArticleScreen.webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                        }
                    }
                }
            }

            step("Нажимает на 5ую ссылку") {
                ArticleScreen.webView {
                    withElement(
                        Locator.XPATH, "//a[contains(@href, 'cite_note-5')]"
                    ) {
                        click()
                    }
                }
            }

            step("Проверяет всплывающее окно и возвращается назад") {
                flakySafely(timeoutMs = 15000){
                BottomSheetReferenceScreen {
                    numberOfReference.isDisplayed()
                    device.uiDevice.pressBack()
                }
            }
            }

            step("Нажимает на 2ую ссылку с классом mw-redirect") {
                ArticleScreen.webView {
                    withElement(
                        // тут тест прошел с текущей статьёй, не знаю как сделать локатор постабильней
                        Locator.XPATH, "//*[@id=\"pcs\"]/section[2]/p[1]/a[5]")
                    {
                        scroll()
                        click()
                    }
                }
            }

            step("Переходит на новую статью по кнопке Read article") {
                BottomSheetReadArticleScreen {
                    readArticleButton.click()
                }
            }

            step("Скроллит до References в новой статье") {
                ArticleScreen.webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                    }
                }
            }
        }
    }
}