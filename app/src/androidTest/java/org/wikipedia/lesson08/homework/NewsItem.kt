package org.wikipedia.lesson08.homework

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

val pager = KViewPager2(
    builder = {
        withId(R.id.main_view_pager)
    },
    itemTypeBuilder = {
        itemType(::NewsItem)
    }
)
class NewsItem(matcher: Matcher<View>) : KViewPagerItem<NewsItem>(matcher) {

val header = KTextView(matcher){
    withId(R.id.view_card_header_title)
}

val menuIcon = KImageView(matcher){
    withId(R.id.view_list_card_header_menu)
}

    val newsItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)},
        itemTypeBuilder = {
            itemType(::NewsItemRecycler)
        }
    )

}