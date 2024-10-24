FROM openjdk:22-jdk
ADD target/two-factor-authentication.jar two-factor-authentication.jar
ENTRYPOINT ["java", "-jar", "/two-factor-authentication.jar"]