FROM java:8
ADD ./build/libs/app.jar /usr/app/app.jar
EXPOSE 80
WORKDIR /usr/app
CMD ["java", "-Djava.security.egd=file:/dev/urandom", "-jar", "app.jar"]