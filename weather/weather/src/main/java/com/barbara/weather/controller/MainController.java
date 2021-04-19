package com.barbara.weather.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			
		} catch (URISyntaxException notFound) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - Error during city request. Typo or the city \""+city+"\" doesn't exist.");
			
		} catch(InterruptedException internalServerError ) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500 - Internal Server Error. Please try reloading this web page.");
			
		} catch(IOException lockedObject) {
			 return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body("Lots of requests in our server. Try again later.");
			
		} catch(JSONException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - Error during city request. Typo or the city \""+city+"\" doesn't exist.");
		}
	}
}
