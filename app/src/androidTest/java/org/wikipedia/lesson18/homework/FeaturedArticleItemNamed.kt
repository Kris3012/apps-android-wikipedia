package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class FeaturedArticleItemNamed(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItemNamed>(matcher){

    val featuredMenuIcon by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка меню"))
    }

    val featuredArticleHeader by lazy{
        KTextView(matcher){
            withId(R.id.view_card_header_title)
        }.name(withParent("Общий заголовок статьи"))
    }

    val featuredArticleTitle by lazy{
        KTextView(matcher){
            withId(R.id.articleTitle)
        }.name(withParent("Название статьи"))
    }

    val articleCard by lazy{
        KView(matcher) {
            withId(R.id.view_featured_article_card_content_container)

        }.name(withParent("Карточка статьи"))
    }

}