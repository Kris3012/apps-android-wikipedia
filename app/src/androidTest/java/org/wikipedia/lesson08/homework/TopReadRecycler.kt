package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

// описание типичного блока ресайклера

class TopReadRecycler(matcher: Matcher<View>) : KRecyclerItem<TopReadRecycler>(matcher) {

    val listItemHeader = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val listItemDescription = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val listNumberIcon = KTextView(matcher) {
        withId(R.id.view_list_card_number)
    }

    val listItemImage = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }


}