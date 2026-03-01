package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

// описание типичного блока ресайклера

class NewsItemRecycler(matcher: Matcher<View>): KRecyclerItem<NewsItemRecycler>(matcher) {
 val image = KImageView(matcher){
     withId(R.id.horizontal_scroll_list_item_image)
 }

val scrollText = KTextView(matcher){
    withId(R.id.horizontal_scroll_list_item_text)
}
}