package com.barbara.weather.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

import org.json.JSONObject;

import com.barbara.weather.model.Response;

public class TemperatureInfo {
	
	public static Response getTemperature(String city) throws IOException, InterruptedException, URISyntaxException {
		String woeid = WeatherInfo.requestWOEID(city);
		JSONObject consolidatedWeather = WeatherInfo.requestWeather(city, woeid);
		
		double celsius = ((BigDecimal) consolidatedWeather.get("the_temp")).doubleValue(); 
		double fahrenheit = (9.0/5.0*celsius + 32);
		
		Response response = new Response(Math.round(celsius), Math.round(fahrenheit));
		
		return response;
	}
	
}

