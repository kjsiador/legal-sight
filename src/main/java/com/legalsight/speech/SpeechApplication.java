package com.legalsight.speech;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.legalsight.speech.repository") 
public class SpeechApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeechApplication.class, args);
	}

}
