package org.wikipedia.lesson09.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher){

    val featuredMenuIcon = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

}