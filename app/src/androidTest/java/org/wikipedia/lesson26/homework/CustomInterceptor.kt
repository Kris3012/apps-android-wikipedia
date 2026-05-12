package org.wikipedia.lesson26.homework

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class CustomInterceptor: TestRunWatcherInterceptor {

    // started методы
    override fun onTestStarted(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "Test started")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "Before section started")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "Main section started")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "After section started")
    }

    // FinishedSuccess методы
    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "Before section finished SUCCESS")

    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "Main section finished SUCCESS")

    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("CUSTOM_INTERCEPTOR", "After section finished SUCCESS")

    }

    // onTestFinished методы

    override fun onBeforeSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        Log.d("CUSTOM_INTERCEPTOR", "Before section finished FAILED",  throwable)

    }

    override fun onMainSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        Log.d("CUSTOM_INTERCEPTOR", "Main section finished FAILED",  throwable)

    }

    override fun onAfterSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        Log.d("CUSTOM_INTERCEPTOR", "After section finished FAILED",  throwable)

    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.d("CUSTOM_INTERCEPTOR", "Test finished - $success")
    }






}