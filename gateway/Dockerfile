# 指定基础镜像，这是分阶段构建的前期阶段
FROM openjdk:11.0.9-jre as builder
# 执行工作目录
#WORKDIR application
# 配置参数
ARG JAR_FILE=target/*.jar
# 将编译构建得到的jar文件复制到镜像空间中
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]