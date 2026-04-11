package org.wikipedia.lesson18.homework


import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

// описание типичного блока ресайклера

class NewsItemRecyclerNamed(matcher: Matcher<View>): KRecyclerItem<NewsItemRecyclerNamed>(matcher) {
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Картинка ресайклера"))

        val scrollText by lazy {
            KTextView(matcher) {
                withId(R.id.horizontal_scroll_list_item_text)
            }.name(withParent("Текст skroll"))
        }
    }
}