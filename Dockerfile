FROM openjdk:8-jre

RUN apt-get update -y

WORKDIR .
# RUN mvn clean install

# Copy sample-maven-app to user directory
COPY ["target/large-file-processor-1.0-SNAPSHOT.jar", "/usr/local/large-file-processor"]


# Execute app
CMD [ "java", "-jar", "/usr/local/large-file-processor/large-file-processor-1.0-SNAPSHOT.jar" ]

