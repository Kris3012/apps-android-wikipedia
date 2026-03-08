package org.wikipedia.lesson10.homework

import androidx.compose.ui.test.hasText
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.component.text.UiTextViewAssertions
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val onboardingImage = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val primaryHeader = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryHeader = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val addLangButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }

    //2ой слайд
    val secondPrimaryHeader = UiTextView {
        withText("New ways")
    }

    //3ий слайд
    val thirdPrimaryHeader = UiTextView {
        withText("Reading lists")
    }

    //4й слайд
    val forthPrimaryHeader = UiTextView {
        withText("Data")
    }

}
