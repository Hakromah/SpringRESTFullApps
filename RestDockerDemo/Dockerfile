FROM openjdk:21-jdk
COPY target/*.jar docker-demo.jar
ENTRYPOINT ["java","-jar","/docker-demo.jar"]
#ENTRYPOINT ["java","-jar","/tmp/docker-demo.jar"]

#These two commands to
#1. docker build . -t hskdev/docker-demo:latest
#2. docker run -it -p 8082:8082 hskdev/docker-demo:latest
#.docker run hskdev/docker-demo:latest => to run our jar file from our custom repository

#  docker cp target/docker-demo.jar  naughty_mendel:/tmp => to copy the our jar file into tmp directory
#  docker exec optimistic_burnell ls /tmp => is to check tmp folder

#  docker run -p 8082:8082 hskdev/docker-demo:latest => to run our jar file diectly from our custom repository in the tmp folder