package org.wikipedia.lesson08.homework

import android.widget.FrameLayout
import androidx.compose.ui.test.hasText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.lesson09.homework.FeaturedArticleItem
import org.wikipedia.views.WikiCardView

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = org.wikipedia.R.layout.fragment_main
    override val viewClass = FrameLayout::class.java

    val feedView = KView {
        withId(R.id.feed_view)
    }

    //заголовок в самом верху экрана, под строкой поиска
    val headerArticleTitle = KTextView{
        withId(R.id.view_card_header_title)
    }

    // кнопка Retry отображается, когда сеть выключена
    val retryButton = UiButton{
        withText("Retry")
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::FeaturedArticleItem)
            itemType(::CustomizeItem)
        }
    )

}