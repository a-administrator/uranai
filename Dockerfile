# 修正後の Dockerfile (v4 - Java 21 対応)

# ステージ 1: ビルド環境 (Temurin JDK 21を使用)
# GradleはJDK 21が必要です
FROM eclipse-temurin:21-jdk-focal AS builder 

# 作業ディレクトリを設定
WORKDIR /app

# (1) Gradle Wrapper関連のファイルをコピー
# gradlew (実行ファイル)と gradle/wrapper ディレクトリをコピー
COPY gradlew .
COPY gradle/wrapper/ gradle/wrapper/ 

# (2) 設定ファイルとソースコードをコピー
COPY build.gradle settings.gradle ./
COPY src/ ./src/

# (3) Gradle Wrapperに実行権限を付与
RUN chmod +x gradlew

# (4) Gradleでアプリケーションをビルド (テストをスキップ)
# build/libs/*.jar が生成される
RUN ./gradlew clean build --no-daemon -x test

# ステージ 2: 実行環境 (軽量なJava JRE 21を使用)
# 実行環境もJDK 21に対応
FROM eclipse-temurin:21-jre-alpine

# ビルドステージからJARファイルをコピー
# アプリケーションのJARファイル名を環境変数で定義（汎用性のため）
# build/libs/your-app-name.jar が生成されると仮定
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder /app/${JAR_FILE} app.jar

# アプリケーションを起動
ENTRYPOINT ["java", "-jar", "app.jar"]