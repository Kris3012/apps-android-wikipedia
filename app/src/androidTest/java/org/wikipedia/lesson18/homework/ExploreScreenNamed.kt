package org.wikipedia.lesson18.homework

import android.widget.FrameLayout
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.invokeByIndex
import org.wikipedia.lesson18.homework.extensions.invokeWithText
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen


object ExploreScreenNamed : NamedScreen<ExploreScreenNamed>() {

    override val screenName = "Explore screen"
    override val layoutId = R.layout.fragment_main
    override val viewClass = FrameLayout::class.java

    val feedView = KView {
        withId(R.id.feed_view)
    }.name(withParent("Лента фида"))

    //заголовок в самом верху экрана, под строкой поиска
    val headerArticleTitle = KTextView {
        withId(R.id.view_card_header_title)
    }.name(withParent("Заголовок статьи"))

        //кнопка More в нижнем таббаре
    val moreMenu = KTextView{
        withText("More")
    }.name(withParent("Меню More"))

//    боттом шит, появляется после нажатия по кнопке More
//    val bottomSheet = KView {
//        withId(R.id.)
//    }.name(withParent("Bottom sheet"))


    val settingsButton = KTextView {
        withText("Settings")
    }.name(withParent("Кнопка Settings"))


    //тут кладем recycler'ы
    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::NewsItemRecyclerNamed)
                itemType(::TopReadRecyclerNamed)
                itemType(::CustomizeItemNamed)
                itemType(::TopReadCardNamed)
            }
        ).name(withParent("Список фидов"))

    }
    // можем добавить обёртку для доступа к слайдам
    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }

    fun customizeBlock(fnc: CustomizeItemNamed.() -> Unit){
        items.invokeWithText("Customize", fnc)
    }

//найти блок TopRead
fun topReadBlock(fnc: TopReadCardNamed.() -> Unit) {
    items.invokeWithText("Top read", fnc)
}

}