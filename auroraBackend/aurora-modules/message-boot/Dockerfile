FROM openjdk:11.0.16-jre-slim

LABEL maintainer="Aurora-Blog"

ARG RUN_DIR=/home/aurora-blog

RUN mkdir -p $RUN_DIR

EXPOSE $AURORA_MESSAGE_SERVER_PORT
EXPOSE 50001

ENV TZ=Asia/Shanghai
ENV AURORA_MESSAGE_SERVER_PORT=8088
ENV JAVA_OPTS="-Xms128m -Xmx256m -Dfile.encoding=UTF-8 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:50001"

COPY target/message-boot-1.0-SNAPSHOT.jar ${RUN_DIR}/app.jar
COPY target/env.sh ${RUN_DIR}

RUN chmod +x env.sh

WORKDIR ${RUN_DIR}
CMD ./env.sh;java ${JAVA_OPTS} -jar app.jar --server.port=$AURORA_MESSAGE_SERVER_PORT