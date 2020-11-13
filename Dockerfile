FROM openjdk:8
ADD target/phone-book.jar phone-book.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "phone-book.jar"]