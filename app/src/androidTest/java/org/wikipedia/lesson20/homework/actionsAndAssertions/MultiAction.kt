package org.wikipedia.lesson20.homework.actionsAndAssertions

import android.view.View
import android.widget.Button
import android.widget.Checkable
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class MultiAction(private val text: String) : ViewAction {

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isDisplayed()
    }

    override fun getDescription(): String {
        return "Perform multi action depending on view type"
    }

    override fun perform(uiController: UiController, view: View) {
        when (view) {
            is Button -> {
                view.performClick()
            }

            is Checkable -> {
                if (!view.isChecked) {
                    view.performClick()
                }
            }

            is EditText -> {
                view.performClick()
                uiController.loopMainThreadUntilIdle()
                ViewActions.replaceText(text).perform(uiController, view)
                uiController.loopMainThreadUntilIdle()
            }

            else -> {
                view.performClick()
            }
        }
    }
}