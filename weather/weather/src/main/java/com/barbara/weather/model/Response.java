package com.barbara.weather.model;

public class Response {
private double celsius;
	
	private double fahrenheit;
	
	
	public Response(double celsius, double fahrenheit) {
		this.celsius = celsius;
		this.fahrenheit = fahrenheit;
	}
	

	public double getFahrenheit() {
		return fahrenheit;
	}

	public void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
	}

	public double getCelsius() {
		return celsius;
	}

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
}
