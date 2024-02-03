FROM ubuntu:latest
LABEL authors="kvojo"

ENTRYPOINT ["top", "-b"]

# Используем базовый образ с поддержкой Java
FROM openjdk:17-alpine

# Копируем JAR-файл приложения в контейнер
COPY target/*.jar /app/users.jar

# Параметры для базы данных (пример)
ENV DB_URL=jdbc:postgresql://db:5432/postgresTask1
ENV DB_USERNAME=root
ENV DB_PASSWORD=secret

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "/app/users.jar"]