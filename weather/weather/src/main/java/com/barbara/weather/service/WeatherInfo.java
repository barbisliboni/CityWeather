package com.barbara.weather.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.barbara.weather.model.Request;

public class WeatherInfo {

	public static String requestWOEID(String city) throws IOException, InterruptedException, URISyntaxException {
		Request requestWOEID = new Request();
		
		if(city.contains(" ")) {
			city = city.replaceAll(" ", "%20");
		}
		
		requestWOEID.setUrl("https://www.metaweather.com/api/location/search/?query="+city);
		HttpResponse<String> responseWOEID = requestWOEID.GET();
		
		String woeid = null;
		
		return woeid;
	}
	
	public static JSONObject requestWeather(String city, String woeid) throws IOException, InterruptedException, URISyntaxException, JSONException {
		
		Request requestWeather = new Request();
		requestWeather.setUrl("https://www.metaweather.com/api/location/"+woeid+"/");
		HttpResponse<String> responseWeather = requestWeather.GET();
		
		JSONObject consolidatedWeather = (JSONObject) ((JSONArray) (new JSONObject(responseWeather.body())).get("consolidated_weather")).get(0);
		
		return consolidatedWeather;
	}
	
}
