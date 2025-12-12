# ステージ 1: ビルド環境 (GradleとJDKを含むイメージを使用)
FROM gradle:jdk17 AS builder

# 作業ディレクトリを設定
WORKDIR /app

# Gradleの設定ファイルとソースコードをコンテナにコピー
COPY build.gradle settings.gradle ./
COPY src/ ./src/

# Gradleでアプリケーションをビルド (テストをスキップ)
# build/libs/your-app-name.jar が生成される
RUN gradle build --no-daemon -x test

# ステージ 2: 実行環境 (軽量なJavaランタイムのみを含むイメージを使用)
FROM openjdk:17-jdk-slim

# ビルドステージからJARファイルをコピー
COPY --from=builder /app/build/libs/*.jar app.jar

# アプリケーションを起動
ENTRYPOINT ["java", "-jar", "app.jar"]