package com.mnadeem.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Value("${kafka.topic.users}")
	private String userTopic;

	@Bean
	public NewTopic buildHscTopic() {
		return TopicBuilder.name(userTopic).build();
	}
	
}
