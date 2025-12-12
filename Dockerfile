# 修正後の Dockerfile (v5 - Java 21 & タグ修正)

# ステージ 1: ビルド環境 (Temurin JDK 21を使用)
# タグを「21-jdk」に変更し、より汎用的な指定に
FROM eclipse-temurin:21-jdk AS builder 

# 作業ディレクトリを設定
WORKDIR /app

# (1) Gradle Wrapper関連のファイルをコピー
COPY gradlew .
COPY gradle/wrapper/ gradle/wrapper/ 

# (2) 設定ファイルとソースコードをコピー
COPY build.gradle settings.gradle ./
COPY src/ ./src/

# (3) Gradle Wrapperに実行権限を付与
RUN chmod +x gradlew

# (4) Gradleでアプリケーションをビルド (テストをスキップ)
RUN ./gradlew clean build --no-daemon -x test

# ステージ 2: 実行環境 (軽量なJava JRE 21を使用)
# タグを「21-jre-alpine」に変更（軽量な実行環境）
FROM eclipse-temurin:21-jre-alpine

# ビルドステージからJARファイルをコピー
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder /app/${JAR_FILE} app.jar

# アプリケーションを起動
ENTRYPOINT ["java", "-jar", "app.jar"]