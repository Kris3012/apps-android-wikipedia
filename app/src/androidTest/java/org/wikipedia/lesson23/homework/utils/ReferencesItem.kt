package org.wikipedia.lesson23.homework.utils

import io.github.kakaocup.kakao.web.KWebView


//т.к. список references в конце статей - list, то делаем им отдельный класс, наследуемся от KWebViewItem

class ReferencesItem(kWebView: KWebView, listContainerXpath: String, ) :
    KWebViewItem(kWebView, listContainerXpath) {

    override val self = this

    //и тут работает наша кастомная функция child из KWebViewElementBase

    val referencesIndex by lazy {
        child("//a[@class='pcs-ref-back-link']")
            .name(withParent("индекс списка"))
        }

val referencesText by lazy{
    child("//div[@class='pcs-ref-body']")
        .name(withParent("текст списка"))
}


}
