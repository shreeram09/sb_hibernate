FROM openjdk:11
EXPOSE 8080
ADD build/libs/demosb-0.0.1.jar demosb-0.0.1.jar
ENTRYPOINT ["java","-jar","demosb-0.0.1.jar"]