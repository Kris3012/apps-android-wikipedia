    package org.wikipedia.lesson24.homework.screens

    import android.view.View
    import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
    import io.github.kakaocup.kakao.recycler.KRecyclerItem
    import org.hamcrest.Matcher
    import org.wikipedia.compose.uiTests.Tags
    import org.wikipedia.lesson18.homework.extensions.invokeWithText
    import org.wikipedia.lesson24.homework.utils.ComposeNamedScreen
    import org.wikipedia.lesson24.homework.utils.createLazyList
    import org.wikipedia.lesson24.homework.utils.invokeWithText
    import org.wikipedia.lesson24.homework.utils.name

    //этот экран можно открыть на онбординге
    object AddLanguageScreen: ComposeNamedScreen<AddLanguageScreen>()  {
        override val screenName = "Экран добавления языка"

    //описываем списки

        val items by lazy {
            createLazyList(
                {
                    hasTestTag(Tags.LANGUAGE_LIST)
                },
                {
                    itemType(::LanguageItem)
                }
            ).name(withParent("Список языков"))
        }

        //создали пустой item для списка выше:
        class WikiLanguagesItem(matcher: Matcher<View>) : KRecyclerItem<WikiLanguagesItem>(matcher)


    }
