FROM openjdk:11-jre-stretch
LABEL maintainer="Olatunde Omotolani "torhlarny15@gmail.com""

VOLUME /tmp

EXPOSE 1998
COPY ./build/libs/insured-open-api-0.0.1-SNAPSHOT.jar insured.jar

CMD ["java", "-jar", "/insured.jar"]