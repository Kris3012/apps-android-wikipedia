package org.wikipedia.lesson09.homework

import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R


object CustomizeScreen: KScreen<CustomizeScreen>(){

    override val layoutId = R.layout.activity_single_fragment
    override val viewClass = FrameLayout::class.java

    //кнопка назад в тулбаре сверху
    val backButton = KImageView(){
        withParent {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }


    // на экране "Customize the feed" указать recycler
    val items = KRecyclerView (
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeFeedItem)
        }
    )
}