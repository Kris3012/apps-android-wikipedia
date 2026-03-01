package org.wikipedia.lesson08.homework

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>) : KViewPagerItem<TopReadItem>(matcher) {

    val headerTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val topReadItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)},
        itemTypeBuilder = {
            itemType(::TopReadRecycler)
        }
    )


}