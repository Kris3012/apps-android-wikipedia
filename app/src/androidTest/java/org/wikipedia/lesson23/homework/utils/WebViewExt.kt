package org.wikipedia.lesson23.homework.utils

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson23.homework.utils.KWebViewElement

fun KWebView.withXPath(xPath: String): KWebViewElement {
    return KWebViewElement(
        webView = this,
        xPath
    )
}