package org.wikipedia.lesson13.homework

import android.widget.LinearLayout
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleScreen: KScreen<ArticleScreen>() {
    override val layoutId = null
    override val viewClass = null


    val webView = KWebView {
        withId(R.id.page_web_view)
    }
}