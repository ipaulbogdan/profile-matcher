docker-compose up -d

./gradlew clean build

docker build -t com.idorasi/profle-matcher .

docker run -p 8080:8080 com.idorasi/profile-matcher
