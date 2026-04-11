package org.wikipedia.lesson18.homework

import android.widget.FrameLayout
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.invokeByIndex
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

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::FeaturedArticleItemNamed)
                itemType(::CustomizeItemNamed)
            }
        ).name(withParent("Список фидов"))

    }
    // можем добавить обёртку для доступа к слайдам
    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}