package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.materialswitch.MaterialSwitch
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

// 1
val textRead = KTextView {
    containsText("Reading")
}

// 2 (текст с указанием текущего размера элементов)
val textSize = KTextView {
    withId(R.id.text_size_percent)
}

// 3
val buttonDecreaseText = KButton {
    withId(R.id.buttonDecreaseTextSize)
}

// 4
val buttonIncreaseText = KButton {
    withId(R.id.buttonIncreaseTextSize)
}

// 5
val seekBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
}

// 6 (первая кнопка ниже сикбара размера)
val firstFontButton = KButton {
    withId(R.id.button_font_family_sans_serif)
}

// 7
val secondFontButton = KButton {
    withId(R.id.button_font_family_serif)
}

// 8
val readingModeSwitcher = KSwitch {
    withParent{
        withId(R.id.readingFocusModeContainer)
    }
    isInstanceOf(MaterialSwitch::class.java)
}

// 9 (иконка очков слева от свитчера)
val readingModeIcon = KImageView {
    withParent {
        withId(R.id.readingFocusModeContainer)
    }
    isInstanceOf(AppCompatImageView::class.java)
}

// 10
val themeHeader = KTextView {
    withText("Theme")
}

// 11 (кнопка с выбором фона)
val firstThemeButton = KButton {
    withId(R.id.button_theme_light)
}

// 12
val secondThemeButton = KButton {
    withId(R.id.button_theme_sepia)
}

// 13
val thirdThemeButton = KButton {
    withId(R.id.button_theme_dark)
}

// 14
val forthThemeButton = KButton {
    withId(R.id.button_theme_black)
}

// 15
val systemThemeSwitcher = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
}

// 16
val dimImagesSwitcher = KSwitch {
    withText("dimming")
}