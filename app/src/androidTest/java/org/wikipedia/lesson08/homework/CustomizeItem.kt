package org.wikipedia.lesson08.homework

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val faceAndColorImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

//    val announcementText = KTextView(matcher) {
//        withParent {
//            withId(R.id.feed_view)
//        }
//        isInstanceOf(MaterialTextView::class.java)
//    }

    val customizeButton = KButton(parent = matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val declineCustomizeButton = KButton(parent = matcher) {
        withId((R.id.view_announcement_action_negative))
    }


}