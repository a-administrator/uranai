# 修正後の Dockerfile

# ステージ 1: ビルド環境 (GradleとJDKを含むイメージを使用)
FROM eclipse-temurin:17-jdk-focal AS builder 

# 作業ディレクトリを設定
WORKDIR /app

# Gradleの設定ファイルとソースコードをコンテナにコピー
COPY build.gradle settings.gradle ./
COPY src/ ./src/

# Gradle Wrapperのファイルもコピー
COPY gradlew ./
# Gradle実行ファイルの実行権限を付与
RUN chmod +x ./gradlew

# Gradleでアプリケーションをビルド (テストをスキップ)
RUN ./gradlew clean build --no-daemon -x test

# ステージ 2: 実行環境 (軽量なJavaランタイムのみを含むイメージを使用)
FROM eclipse-temurin:17-jre-alpine

# ビルドステージからJARファイルをコピー
COPY --from=builder /app/build/libs/*.jar app.jar

# アプリケーションを起動
ENTRYPOINT ["java", "-jar", "app.jar"]