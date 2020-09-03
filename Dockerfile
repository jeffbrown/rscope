FROM openjdk:14-alpine
COPY build/libs/rscope-*-all.jar rscope.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "rscope.jar"]