package org.wikipedia.lesson22.homework

import androidx.compose.ui.test.hasText
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson19.homework.utils.action
import org.wikipedia.lesson19.homework.utils.verify

class ArticleScreenWithWidgetTest : BaseTest() {


    @Test
    fun checkThemeTestOne() {
        run {

            action.click(OnboardingScreenNamed.skipButton)

            ExploreScreenNamed {
                featuredArticleBlock {
                    verify.isDisplayed(this)
                    action.click(featuredArticleTitle)
                }
            }

            ArticleScreenWithWidget {
                popupCloseButton {
                    verify.isDisplayed(this)
                    action.click(this)
                }
            }

            ArticleScreenWithWidget {
                action.click(themeTab)

                ArticleScreenWithWidget {
                    articleThemeWidget {
                        verify.isDisplayed(this)
                        action.click(increaseTextSizeButton)
                        verify.hasText(textSize, "110%")
                        repeat(2) {
                            action.click(decreaseTextSizeButton)
                        }
                        verify.hasText(textSize, "90%")
                    }
                }
            }

        }
    }


    @Test
    fun checkThemeTestTwo() {
        run {

            action.click(OnboardingScreenNamed.skipButton)

            ExploreScreenNamed {
                featuredArticleBlock {
                    verify.isDisplayed(this)
                    action.click(featuredArticleTitle)
                }
            }

            ArticleScreenWithWidget {
                popupCloseButton {
                    verify.isDisplayed(this)
                    action.click(this)
                }
            }

            ArticleScreenWithWidget {
                action.click(themeTab)

                ArticleScreenWithWidget{
                    articleThemeWidget {
                        verify.isDisplayed(this)
                        matchSystemSwitcher.isChecked()
                        action.click(matchSystemSwitcher)
                        verify.apply {
                            themeDarkButton.isEnabled()
                            themeBlackButton.isEnabled()
                        }
                        action.click(matchSystemSwitcher)
                        verify.apply {
                            themeDarkButton.isDisabled()
                            themeBlackButton.isDisabled()
                        }
                    }
                }
            }
        }
    }
}
