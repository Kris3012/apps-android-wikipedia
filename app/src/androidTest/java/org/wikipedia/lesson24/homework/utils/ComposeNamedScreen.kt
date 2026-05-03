package org.wikipedia.lesson24.homework.utils

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.ComposeScreen
import org.wikipedia.lesson18.homework.utils.NameHierarchy

//это базовый экран с полем названия

abstract class ComposeNamedScreen<T : ComposeScreen<T>>() : ComposeScreen<T>() {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}