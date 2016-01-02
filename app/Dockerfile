FROM java:8
ADD ./build/libs/app.jar /usr/app/app.jar
EXPOSE 80
WORKDIR /usr/app
ENTRYPOINT ["java"]
CMD ["-Djava.security.egd=file:/dev/urandom", "-jar", "app.jar"]