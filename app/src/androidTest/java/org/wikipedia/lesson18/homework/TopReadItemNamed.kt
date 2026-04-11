package org.wikipedia.lesson18.homework

import org.wikipedia.lesson08.homework.TopReadRecycler

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.invokeAtIndex
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class TopReadItemNamed(matcher: Matcher<View>) : KViewPagerItem<TopReadItemNamed>(matcher) {

    val headerTitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent(""))
    }

    val headerMenu by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent(""))
    }

    val topReadItems by lazy{
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)},
            itemTypeBuilder = {
                itemType(::TopReadRecycler)
            }
        ).name(withParent("Список статей Top Read"))
    }

//    fun item(index: Int, fnc: TopReadItemNamed.() -> Unit) {
//        topReadItems.invokeAtIndex(index, fnc)
//    }
}