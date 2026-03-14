package org.wikipedia.lesson11.homework

import android.view.Surface
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson10.homework.OnboardingUiScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class ADBTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    // 1.поворот экрана и проверка ориентации
    @Test
    fun checkDeviceOrientation() {
        before {
        }.after {
            // восстанавливаем ориентацию девайса
            device.uiDevice.setOrientationNatural()
        }
            .run {
                step("Проверяет смену ориентации устройства") {
                    OnboardingUiScreen {
                        device.uiDevice.setOrientationLandscape()
                        // делаем ожидание в 3 сек
                        Thread.sleep(3000)
                        val actual = device.uiDevice.getDisplayRotation()
                        val expected = Surface.ROTATION_90
                        Assert.assertEquals(expected, actual)
                    }

                }
            }
    }

    // 2. выключение экрана, включение и проверка отображения элемента
    @Test
    fun checkItemAfterShutDown() {
        before {

        }.after {
            device.uiDevice.pressHome()
        }.run {
            step("Проверяет отображение кнопки Continue") {
                OnboardingUiScreen {
                    continueButton.isDisplayed()
                    device.uiDevice.sleep()
                    device.uiDevice.wakeUp()
                    Thread.sleep(2000)
                    step("Проверяет, что после включения экрана отображается кнопка Continue") {
                        continueButton.isDisplayed()
                    }
                }
            }
        }
    }

    // 3."свернуть" приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента
    @Test
    fun checkItemAfterReturnToApp() {
        before {
        }.after {
            device.uiDevice.pressHome()
        }.run {
            step("Проверяет элемент экрана Explore после возврата в приложение") {
                OnboardingUiScreen {
                    onboardingImage.isDisplayed()
                    device.uiDevice.pressHome()
                    repeat(2) {
                        device.uiDevice.pressRecentApps()
                    }
                    Thread.sleep(1000)
                    onboardingImage.isDisplayed()
                }

            }
        }
    }

    // 4. выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry.
    // Включить сеть и нажать Retry, проверить отображение заголовка
    @Test
    fun checkHeaderAfterTurnOnWiFiConnection() {
        before {
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            device.network.toggleWiFi(true)
        }.run {
            step("Проверяет кнопку Skip на онбординге") {
                OnboardingUiScreen {
                    skipButton.isDisplayed()
                    skipButton.click()
                }
            }
            step("Включает сеть и нажимает кнопку Retry") {
                ExploreScreen {
                    adbServer.performAdb("shell svc wifi enable")
                    retryButton.isDisplayed()
                    retryButton.click()
                    Thread.sleep(4000)
                    headerArticleTitle.isDisplayed()
                }
            }

        }
    }

    // 5. поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)
    @Test
    fun checkTextAfterLanguageChange() {
        before {
        }.after {
            device.uiDevice.pressHome()
            device.language.switchInApp(Locale("en"))
        }.run {
            step("Меняет текст приложения") {
                device.language.switchInApp(Locale("ru"))
                OnboardingUiScreen {
                    continueButton.hasText("Продолжить")
                }
            }
        }
    }

    // 6. проверить, что сейчас активна MainActivity
    @Test
    fun checkMainActivityIsActive() {
        before {
        }.after {
            device.uiDevice.pressHome()
        }.run {
            step("Закрывает онбординг"){
                OnboardingUiScreen{
                    skipButton.click()
                }
            }
            step("Проверяет, что MainActivity активна") {
                Thread.sleep(3000)
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}





