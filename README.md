# cityWeather

This repository refers to the application developed to retrieve the temperature in celsius and farenheit of a city/state/country you choose.

## How does it work (technically speaking)?
It starts with the controller, which has its endpoint called ("/weather/city/{location}"), for instance:
```
/weather/city/london
```

and external service/model called in it. Inside the Request model, it has a request using GET, but here's the question: why get? Simple. Using GET, as we aren't passing any sensitive information, we can just write the params (in this case, the place we want to know the weather) in the request URL.
After making a request, it passes the params through the MetaWeather API and gets the information that was specified (celsius and farenheit) to show on the screen as a Json Object. <br>
While making the response methods, as the array was a JSON Array and Java is a strongly typed language, Casting had to be used to transform the Json Array item that we wanted in a Json Object, so then we could handle this specified information from the body of it. It will be like this: 
```
String woeid = ((JSONObject) new JSONArray(responseWOEID.body()).get(0)).get("woeid").toString();
```
So what was done here? A variable called woeid receives one of the values from the JSONArray, getting the "woeid" by acessing its key on the JSONObject and transforming it into a String. <br>
Important: to deal with JSON, a external library had to be used. Subsequently, after getting this item, we had to specify the name of the array and which item from it we wanted (with Casting), and following all this, we have the response we wanted.  

## Methods
**GET /weather/city/{location}**

### Arguments

**location:** the name of the city you chose

### Examples

http://localhost:8080/weather/city/são%20paulo

http://localhost:8080/weather/city/rio%20de%20janeiro

http://localhost:8080/weather/city/brasília


### Response Body

200 - OK
```javascript
{
  "celsius": float,
  "farenheit": float
}
```

404 - Not Found

```javascript
{
  "response": string
}
```



## How to use it?
First, in the URL of this repository of mine, after "github", write "1s", like this: 
```
https://github1s.com/barbisliboni/cityWeather
``` 
Doing it, this code will open in an IDE on the browser. After this, run the code, check the terminal to know if its already running, and write the URL specified above in wherever you want to test it (Postman, browser, Fiddler, etc).
<br>
<br>
### PS: Don't forget to use accent marks and space while writing it. 
### PS²: It will show only the main cities/states if you're seaching a place which is not in the USA.
