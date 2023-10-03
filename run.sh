docker-compose up -d
sleep 5

./gradlew clean build

./gradlew bootRun
