#!/bin/bash

# 1. создать эмулятор
~/Library/Android/sdk/cmdline-tools/latest/bin/avdmanager create avd \
 --name pixel_7 \
 --package "system-images;android-34;google_apis;x86_64" \
 --device "pixel"

# 2. запустить эмулятор
~/Library/Android/sdk/emulator/emulator -avd pixel_7 \
 -no-boot-anim \
 -skin 480x800 \
 -port 5584 &

# 3. sleep
sleep 120

# 4. gradlew test
./gradlew app:connectedAlphaDebugAndroidTest "-Pandroid.testInstrumentationRunnerArguments.class=org.wikipedia.lesson26.homework.BehaviorTests#simpleTest"

# 5. выключить эмулятор
~/Library/Android/sdk/platform-tools/adb  -s emulator-5584 emu kill

# 6. открыть отчет
allure generate app/build/reports/allure-results --clean -o allure-report
open allure-report/index.html