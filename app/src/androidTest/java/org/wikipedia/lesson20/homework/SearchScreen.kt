package org.wikipedia.lesson20.homework

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matchers.endsWith
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object SearchScreen : NamedScreen<SearchScreen>() {
    override val screenName = "Экран поиска"
    override val layoutId = null
    override val viewClass = null


    val searchInput by lazy {
        KView { withId(R.id.search_card) }
    }


}
