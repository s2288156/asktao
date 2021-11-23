FROM my01-registry.cn-beijing.cr.aliyuncs.com/my_car_iot/openjdk:11.0.13-jre-slim

ADD ./iot-start/target/zhcl-app.jar /zhcl-app.jar

ADD ./script/start-app.sh /start-app.sh

RUN chmod +x /start-app.sh

ENTRYPOINT ["sh","start-app.sh"]

MAINTAINER WuChunyang
