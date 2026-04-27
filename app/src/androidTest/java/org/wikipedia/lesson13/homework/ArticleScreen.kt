package org.wikipedia.lesson13.homework

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.lesson23.homework.utils.KWebViewElement
import org.wikipedia.lesson23.homework.utils.KWebViewList
import org.wikipedia.lesson23.homework.utils.ReferencesItem
import org.wikipedia.lesson23.homework.utils.withXPath

object ArticleScreen: NamedScreen<ArticleScreen>() {

    override val screenName = "Экран статьи"
    override val layoutId = null
    override val viewClass = null


    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val webViewArticleTitle by lazy {
        KWebViewElement(
            webView,
            "//h1"
        ).name(withParent("Заголовок статьи"))
    }

        //либо можно на основе  WebViewExt  описать элемент заголовка так:

//    val webViewArticleTitle by lazy {
//        webView.withXPath("//h1")
//            .name(withParent("Заголовок статьи"))
//
//    }


val webViewReferencesTitle by lazy {
    KWebViewElement(
        webView,
        "//*[@id=\"References\"]"
    ).name(withParent("Заголовок References"))
}


val referencesList by lazy {
    KWebViewList(
        webView,
        "//ol"
    ).name(withParent("Список references"))
}



    //функция обращения к блоку References по индексу:

    fun referenceItem(index: Int, fnc: ReferencesItem.() -> Unit){
        referencesList.childAt(index, fnc)
    }

}
