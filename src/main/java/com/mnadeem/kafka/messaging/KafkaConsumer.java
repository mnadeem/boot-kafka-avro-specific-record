package com.mnadeem.kafka.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import io.confluent.developer.User;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "#{'${kafka.topic.users}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
	public void consume(User record, Acknowledgment acknowledgment) {
		LOGGER.info(String.format("Consumed message -> %s", record));
		acknowledgment.acknowledge();
	}
}
