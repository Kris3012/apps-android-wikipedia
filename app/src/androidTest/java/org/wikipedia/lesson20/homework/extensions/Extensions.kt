package org.wikipedia.lesson20.homework.extensions

import androidx.test.espresso.action.ViewActions
import io.github.kakaocup.kakao.common.views.KBaseView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson20.homework.actionsAndAssertions.EqualsWithTrimAssertion
import org.wikipedia.lesson20.homework.actionsAndAssertions.MultiAction

fun KBaseView<*>.multiAction() {
    try {
        view.perform(MultiAction("On"))
    } catch (e: Exception) {
        view.perform(ViewActions.click())
    }
}

fun KBaseView<*>.equalsWithTrim(expected: String) {
    view.check(EqualsWithTrimAssertion(expected))
}
