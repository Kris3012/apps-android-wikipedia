package org.wikipedia.lesson13.homework

import android.widget.FrameLayout
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView


object BottomSheetReferenceScreen : KScreen<BottomSheetReferenceScreen>() {
        override val layoutId = null
        override val viewClass = null

        val numberOfReference = KTextView {
            containsText("5")
        }

}