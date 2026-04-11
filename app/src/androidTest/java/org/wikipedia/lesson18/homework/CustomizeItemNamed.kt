package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class CustomizeItemNamed(matcher: Matcher<View>) : KRecyclerItem<CustomizeItemNamed>(matcher) {

    val faceAndColorImage by lazy{
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("Иконка кастомизации"))
    }

    val customizeButton by lazy{
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Кнопка включения кастомизации"))
    }

    val declineCustomizeButton by lazy{
        KButton(matcher) {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Кнопка отмены кастомизации"))
    }


}