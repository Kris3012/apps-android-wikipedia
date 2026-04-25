package org.wikipedia.lesson22.homework

import androidx.test.espresso.matcher.ViewMatchers.withParent
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ArticleScreenWithWidget : NamedScreen<ArticleScreenWithWidget>() {

    override val screenName = "Экран статьи"
    override val layoutId = null
    override val viewClass = null

//    val articleTitle by lazy{
//        KTextView(matcher){
//            withId(R.id.articleTitle)
//        }.name(withParent("Заголовок статьи"))
//    }


    //кнопка Theme в нижнем таббаре
    val themeTab by lazy {
        KTextView {
            withText("Theme")
            isDescendantOfA { withId(R.id.page_actions_tab_layout) }
        }.name(withParent("Таб Theme"))
    }

        //попап про Wikipedia games
        val popupCloseButton = KView {
            withContentDescription("Close")
        }.name(withParent("Кнопка закрытия попапа"))


        val articleThemeWidget by lazy {
            ArticleThemeWidgets {

            }.name(withParent("Виджет Theme"))
        }


    }




