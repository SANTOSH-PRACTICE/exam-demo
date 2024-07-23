package com.deliveryboy.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.kafka.config.AppConstants;

@Service
public class KafkaService {
	
	private Logger logger=LoggerFactory.getLogger(KafkaService.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	public boolean updateLocation(String location) {
		
		
		//for (int i = 1; i < 10000; i++) {
			
			this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
			 this.logger.info("message produced");
			 System.out.println("------------------------------");
			
		//	
		//}
		 return true;
		 
		
	}
}
