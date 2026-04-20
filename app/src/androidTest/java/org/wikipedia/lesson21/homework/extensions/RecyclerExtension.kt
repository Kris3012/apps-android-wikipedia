package org.wikipedia.lesson21.homework.extensions

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.homework.extensions.getName
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndResId(
    index: Int,
    limit: Int = 10,
    skipItems: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {
    var currentIndex = 0
    var found = false

    val lastIndex = (limit + skipItems).coerceAtMost(getSize()) - 1
    val firstIndex = skipItems.coerceAtMost(lastIndex)

    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            if (index == currentIndex) {
                found = true
                name(
                    this@invokeAtIndexAndResId.getName()
                        .withParent(name)
                )
                function()
            }
            currentIndex++
        }
        if (found) break
    }
    if (!found) {
        throw IllegalStateException(
            "Элемент с index=$index не найден"
        )
    }
}