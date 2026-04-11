package org.wikipedia.lesson09.homework

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher){

    val featuredMenuIcon = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val featuredArticleHeader = KTextView(matcher){
        withId(R.id.view_card_header_title)
    }

    val featuredArticleTitle = KTextView(matcher){
        withId(R.id.articleTitle)
    }

    val articleCard = KView(matcher) {
        withId(R.id.view_featured_article_card_content_container)

    }

}