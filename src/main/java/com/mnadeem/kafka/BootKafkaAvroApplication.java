package com.mnadeem.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mnadeem.kafka.messaging.KafkaProducer;

import io.confluent.developer.User;

@SpringBootApplication
public class BootKafkaAvroApplication implements CommandLineRunner {
	
	@Autowired
	private KafkaProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(BootKafkaAvroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendMessage(new User("Nadeem", 1));		
	}
}
