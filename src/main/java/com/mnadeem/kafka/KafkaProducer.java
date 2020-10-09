package com.mnadeem.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.confluent.developer.User;

@Service
public class KafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@Value("${kafka.topic.users}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	void sendMessage(User user) {
		this.kafkaTemplate.send(this.topic, user.getName().toString(), user);
		LOGGER.info(String.format("Produced user -> %s", user));
	}
}
