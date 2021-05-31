FROM openjdk:11-jre-stretch
LABEL maintainer="Olatunde Omotolani "torhlarny15@gmail.com""

EXPOSE 1998
COPY --from=build ./build/libs/insured-open-api-0.0.1-SNAPSHOT.jar /usr/local/lib/insured.jar

CMD ["java", "-jar", "/insured.jar"]