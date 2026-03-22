package org.wikipedia.lesson13.homework

import android.widget.FrameLayout
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R



object BottomSheetReadArticleScreen : KScreen<BottomSheetReadArticleScreen>() {
    override val layoutId = org.wikipedia.R.layout.dialog_link_preview
    override val viewClass = FrameLayout::class.java

    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }
}