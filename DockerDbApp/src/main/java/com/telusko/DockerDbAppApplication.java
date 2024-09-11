package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerDbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerDbAppApplication.class, args);
		// To run the Swagger UI
		//http://localhost:8080/studentApp/swagger-ui/index.html
	}

}
