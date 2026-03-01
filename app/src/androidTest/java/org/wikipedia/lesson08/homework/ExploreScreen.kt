package org.wikipedia.lesson08.homework

import android.widget.FrameLayout
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = org.wikipedia.R.layout.fragment_main
    override val viewClass = FrameLayout::class.java


    val items = KViewPager2 (
        builder = {
            withId(R.id.main_view_pager)
        },
        itemTypeBuilder = {
            itemType(::CustomizeItem)
            itemType(::DateItem)
            itemType(::NewsItem)
            itemType(::TopReadItem)
        }
    )
}