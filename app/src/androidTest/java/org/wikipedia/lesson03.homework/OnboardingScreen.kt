package org.wikipedia.lesson03.homework
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import org.wikipedia.R
import org.wikipedia.views.AppTextView

// 1
val firstOnboardingImage = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

// 2
val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)

// 3
val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)

// 4
val firstPrimaryHeader = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_welcome_title_v2
)

// 5
val languageInput = listOf(
   RecyclerView::class.java,
    R.id.languagesList
)

// 6
val addLanguageButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)


// экран 2

// 7
val secondOnboardingImage = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

// 8
val secondPrimaryHeader = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_explore_title
)

// 9
val welcomeTextSubheader = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_explore_text
)