package com.telusko.service;

import com.telusko.model.Student;
import com.telusko.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;


    public String sendMessage(Student student) {
        kafkaTemplate.send(AppConstants.TOPIC_NAME, student);
        return "Message sent to Kafka successfully";
    }

//    public Student receiveMessage() {
//        return new Student();
//    }
}
