package com.telusko;

import com.telusko.util.AppConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ApKafkaSubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApKafkaSubApplication.class, args);
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = "group_student")
    public void subscribeMsgFromKafkaTopic(String studData) {
        System.out.println("Message is coming from Kafka Server");
        System.out.println(studData);
    }

}
