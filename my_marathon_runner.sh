#!/bin/bash

# Компилирует приложение и тесты в apk файлы
./gradlew assembleAlphaDebug assembleAlphaDebugAndroidTest

# Создаёт пару эмуляторов
echo "no" | $HOME/Library/Android/sdk/cmdline-tools/latest/bin/avdmanager create avd -n emulator1 -k "system-images;android-34;google_apis;x86_64" --force
echo "no" | $HOME/Library/Android/sdk/cmdline-tools/latest/bin/avdmanager create avd -n emulator2 -k "system-images;android-34;google_apis;x86_64" --force

# Запускает эмуляторы
nohup $HOME/Library/Android/sdk/emulator/emulator \
-avd emulator1 -port 5554 > emulator1.log 2>&1 &

nohup $HOME/Library/Android/sdk/emulator/emulator \
-avd emulator2 -port 5556 > emulator2.log 2>&1 &

# Ждёт пару минут, чтобы эмуляторы точно загрузились
sleep 300

# Проверяем девайсы
echo "Connected devices"
adb devices


# Запускает Marathon
marathon --marathonfile Marathonfile

# Завершает эмуляторы после завершения работы Marathon
adb -s emulator-5554 emu kill
adb -s emulator-5556 emu kill