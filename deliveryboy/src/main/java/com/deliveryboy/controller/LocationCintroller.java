package com.deliveryboy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.kafka.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationCintroller {

	@Autowired
	private KafkaService kafkaService;
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() throws InterruptedException
	{
		
		for (int i = 1; i < 200000; i++) {
			
			this.kafkaService.updateLocation("Updated Location this Place"+"("+Math.round( Math.random()*100)+","+Math.round(Math.random()*100)+""+")");
			Thread. sleep(1000);
		}
		//this.kafkaService.updateLocation(Math.round( Math.random()*100)+","+Math.round(Math.random()*100));
		//this.kafkaService.updateLocation("1000027373");
		return new ResponseEntity<>(Map.of("message","Loctaion updated"),HttpStatus.OK);
	}

}
