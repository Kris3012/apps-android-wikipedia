package org.wikipedia.lesson08.homework

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikimedia.testkitchen.R

class DateItem(matcher: Matcher<View>) : KViewPagerItem<DateItem>(matcher) {

val currentDate = KTextView (matcher) {
    withId(org.wikipedia.R.id.day_header_text)
}
}