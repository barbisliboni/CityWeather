package com.barbara.weather.controller;

import java.math.BigDecimal;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbara.weather.model.APIException;
import com.barbara.weather.model.Request;
import com.barbara.weather.model.Response;

@RequestMapping("/weather")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {
	
	@GetMapping("/city/{city}")
	public ResponseEntity<Object> GetTemperatureByCity(@PathVariable String city) {
		
		try {
			Request requestWOEID = new Request();
			if(city.contains(" ")) {
				city = city.replaceAll(" ", "%20");
			}
			requestWOEID.setUrl("https://www.metaweather.com/api/location/search/?query="+city);
			HttpResponse<String> responseWOEID = requestWOEID.GET();
			
			String woeid = ((JSONObject) new JSONArray(responseWOEID.body()).get(0)).get("woeid").toString();
			
			Request requestWeather = new Request();
			requestWeather.setUrl("https://www.metaweather.com/api/location/"+woeid+"/");
			HttpResponse<String> responseWeather = requestWeather.GET();
							
			JSONObject consolidatedWeather = (JSONObject) ((JSONArray) (new JSONObject(responseWeather.body()))
					.get("consolidated_weather"))
					.get(0);
			
			double celsius = ((BigDecimal) consolidatedWeather.get("the_temp")).doubleValue(); 
			double fahrenheit = (9.0/5.0*celsius + 32);
			
			Response response = new Response(Math.round(celsius), Math.round(fahrenheit));
			
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			APIException exception = new APIException();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
		}
	}
}
