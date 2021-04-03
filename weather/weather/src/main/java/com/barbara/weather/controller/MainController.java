package com.barbara.weather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbara.weather.model.APIException;
import com.barbara.weather.model.Response;
import com.barbara.weather.service.TemperatureInfo;

@RequestMapping("/weather")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {
	
	@GetMapping("/city/{city}")
	public ResponseEntity<Object> GetTemperatureByCity(@PathVariable String city) {
		
		try {
			Response response = TemperatureInfo.getTemperature(city);
			
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			APIException exception = new APIException();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
		}
	}
}
