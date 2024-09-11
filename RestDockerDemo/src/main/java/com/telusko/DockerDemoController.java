package com.telusko;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoController {

    @RequestMapping("/")
    public String greeting() {
        // docker exec competent_tharp ls / tmp
        // docker commit --change='CMD ["java","-jar","/tmp/docker-demo.jar"]' competent_tharp telusko/docker-demo:v1
        // docker run telusko/docker-demo:v1
        //ls -l /tmp/docker-demo.jar



//        FROM openjdk:24-jdk-oracle
//        COPY target/docker-demo.jar /tmp/docker-demo.jar
//        CMD ["java", "-jar", "/tmp/docker-demo.jar"]
        return "Hello Docker World!";
    }
}
