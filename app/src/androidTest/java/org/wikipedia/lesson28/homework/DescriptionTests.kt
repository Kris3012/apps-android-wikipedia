package org.wikipedia.lesson28.homework

import io.qameta.allure.kotlin.Description
import org.wikipedia.BuildConfig
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenNamed
import org.wikipedia.lesson18.homework.OnboardingScreenNamed
import org.wikipedia.lesson20.homework.SearchScreen
import org.wikipedia.lesson19.homework.tests.BaseTest
import org.wikipedia.lesson19.homework.utils.action
import org.wikipedia.lesson19.homework.utils.verify


class DescriptionTests : BaseTest() {

    //первая функция
    private fun searchShouldFindResults() {
        run {

            action.click(OnboardingScreenNamed.skipButton)

            action.click(ExploreScreenNamed.searchMenu)

            verify.isDisplayed(SearchScreen.searchInput)

            SearchScreen.searchInput.typeText(myRule.testData)

            verify.isDisplayed(SearchScreen.searchResultsItems)
        }
    }

    //вторая функция с невалидным результом
    private fun searchShouldNotFindResults() {
        run {
            action.click(OnboardingScreenNamed.skipButton)

            action.click(ExploreScreenNamed.searchMenu)

            action.click(SearchScreen.searchInput)

            verify.isDisplayed(SearchScreen.searchInput)

            SearchScreen.searchInput.typeText(myRule.testData)

            verify.isDisplayed(SearchScreen.emptyContainer)
        }
    }

    //пока что тест не работает

    @Test
    @io.qameta.allure.kotlin.Description("valid")
    fun customDescriptionTestOne() {
        run {
            searchShouldFindResults()
        }
    }

    @Test
    @io.qameta.allure.kotlin.Description("")
    fun customDescriptionTestTwo() {
        run {
            searchShouldNotFindResults()
        }
    }
}