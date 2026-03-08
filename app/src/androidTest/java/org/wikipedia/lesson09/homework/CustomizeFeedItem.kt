package org.wikipedia.lesson09.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R

// в самом recycler опишем, где свитчер отключения Featured Article
class CustomizeFeedItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeFeedItem>(matcher) {

    val featuredSwitcher = KCheckBox(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }


}