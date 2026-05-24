#!/bin/bash

# 1. запустить наш образ
docker run --rm -d --name my-container \
-v ".:/project" \
-w /project \
android-jdk21 sleep infinity

# 2. запустить в этом образе  команду очистки сборочной директории
docker exec my-container sh -c \
"sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew app:clean"
