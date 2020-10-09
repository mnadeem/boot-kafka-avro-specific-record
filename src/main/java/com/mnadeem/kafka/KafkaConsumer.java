package com.mnadeem.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.confluent.developer.User;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "#{'${topic.name}'}", groupId = "simple-consumer")
	public void consume(User record) {
		LOGGER.info(String.format("Consumed message -> %s", record));
	}
}
