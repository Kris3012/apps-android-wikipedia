package org.wikipedia.lesson24.homework.screens

import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object WikipediaLanguagesScreen : NamedScreen<WikipediaLanguagesScreen>() {
    override val screenName = "Экран добавления языка (XML)"
    override val layoutId = null
    override val viewClass = null

    val languages by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.wikipedia_languages_recycler)
            },
            itemTypeBuilder = {
                itemType(::WikiLanguagesItem)
            }
        ).name(withParent("Блоки языков"))


    }

    val wikiLanguageTitle by lazy{
        KTextView{
            withText("Add language")
        }.name(withParent("Кнопка Add language"))
    }


}