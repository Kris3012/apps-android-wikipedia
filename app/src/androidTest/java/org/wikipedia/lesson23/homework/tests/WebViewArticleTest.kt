package org.wikipedia.lesson23.homework.tests

import androidx.compose.ui.test.hasText
import org.junit.Test
import org.wikipedia.lesson13.homework.ArticleScreen
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson19.homework.utils.action
import org.wikipedia.lesson19.homework.utils.verify
import org.wikipedia.lesson22.homework.ArticleScreenWithWidget
import org.wikipedia.lesson22.homework.ArticleScreenWithWidget.invoke
import org.wikipedia.lesson22.homework.ArticleScreenWithWidget.popupCloseButton

class WebViewArticleTest : BaseTest() {

    @Test
    fun checkReferenceIndexIsValid() {
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
                    Thread.sleep(3000)
                }
            }

            //зашли на нашу статью
            verify.isDisplayed(ArticleScreen.webViewArticleTitle)

            //кликает по заголовку References в конце статьи
            action.click(ArticleScreen.webViewReferencesTitle)

            //берёт второй блок
                //проверяет что текст в индексе блока равен [2]

            ArticleScreen.referenceItem(2){
                verify.hasText(referencesIndex,"[2]")
            }
        }
    }


}

