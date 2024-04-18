FROM openjdk:21
WORKDIR /todo

COPY build/libs/todo-0.0.1 ./todoApp.jar

EXPOSE 8098

ENTRYPOINT ["java", "-jar", "./todoApp.jar"]