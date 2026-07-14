# Stage 1: Build
FROM eclipse-temurin:21-jdk-alpine@sha256:1ff763083f2993d57d0bf374ab10bb3e2cb873af6c13a04458ebbd3e0337dc76 AS build
WORKDIR /app
# Copy Gradle wrapper and source code
COPY gradlew .
COPY gradle gradle
COPY build.gradle ./
RUN --mount=type=cache,target=/root/.gradle ./gradlew dependencies --no-daemon || return 0
COPY src src
# Build the application
RUN --mount=type=cache,target=/root/.gradle ./gradlew bootJar -x test --no-daemon

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine@sha256:3f08b13888f595cc49edabea7250ba69499ba25602b267da591720769400e08c
WORKDIR /app
# Copy only the build jar
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

