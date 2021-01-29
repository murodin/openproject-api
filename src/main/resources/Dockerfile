FROM adoptopenjdk/openjdk11:ubi
COPY ./target/openprojectapi.jar /usr/openproject/api/
WORKDIR /usr/openproject/api/
RUN sh -c 'touch openprojectapi.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","openprojectapi.jar"]
