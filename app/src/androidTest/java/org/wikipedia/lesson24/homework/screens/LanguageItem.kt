package org.wikipedia.lesson24.homework.screens

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.kaspersky.components.composesupport.core.KNode
import io.github.kakaocup.compose.foundation.KTextNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.uiTests.Tags
import org.wikipedia.lesson24.homework.utils.name
import org.wikipedia.lesson24.homework.utils.withParent

//список на экране композ
class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val localizedText by lazy {
       child<KNode>{
           hasTestTag(Tags.LOCALIZED_LANGUAGE_NAME)
       }.name(withParent("Локализованный текст языка"))
    }

    val canonicalText by lazy {
        child<KNode>{
            hasTestTag(Tags.CANONICAL_LANGUAGE)
        }.name(withParent("Оригинальный текст языка"))
    }


}