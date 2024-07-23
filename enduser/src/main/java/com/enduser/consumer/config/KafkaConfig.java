package com.enduser.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.enduser.app.constants.ApplicationConsants;



@Configuration
public class KafkaConfig {
	
	
	
	@KafkaListener(topics = ApplicationConsants.LOCATION_UPDATE_TOPIC,groupId = ApplicationConsants.GROUP_ID)
	public void updatedLocation(String value)
	{
		System.out.println(value);
	}

}
