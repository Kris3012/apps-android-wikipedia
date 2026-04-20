package org.wikipedia.lesson19.homework.screens

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class SettingsRecyclerItem(matcher: Matcher<View>) : KRecyclerItem<SettingsRecyclerItem>(matcher) {


    val listItemSwitch by lazy {
        KCheckBox(matcher) {
            isDescendantOfA(matcher)
            withId(R.id.switchWidget)
        }
    }

    val listItemTitle by lazy {
        KTextView {
            withId(R.id.title)
        }
    }

    val listItemIcon by lazy {
        KImageView {
            withId(R.id.right_icon)
        }
    }
}