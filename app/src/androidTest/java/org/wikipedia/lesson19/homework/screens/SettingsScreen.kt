package org.wikipedia.lesson19.homework.screens

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ExploreScreenNamed.items
import org.wikipedia.lesson18.homework.extensions.invokeWithText
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object SettingsScreen: NamedScreen<SettingsScreen>() {

    override val screenName = "Экран настроек"
    override val layoutId = null
    override val viewClass = null

// тут ресайклер настроек
    val settingsItems by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType (::SettingsRecyclerItem)
            }
        ).name(withParent("Список настроек"))
    }

    //найти блок настроек
    fun settingsBlock(fnc: SettingsRecyclerItem.() -> Unit){
        items.invokeWithText("Settings", fnc)
    }

    fun settingItemWithTitle(title: String, fnc: SettingsRecyclerItem.() -> Unit) {
        settingsItems.childWith<SettingsRecyclerItem> {
            withDescendant { withText(title) }
        }.also(fnc)
    }
}