# cityWeather

This repository refers to the application developed to retrieve the temperature in celsius and farenheit of a city/state/country you choose.

## How does it work (technically speaking)?
It starts with the controller, which has its endpoint called ("/weather/city/{location}"), for instance:
```
/weather/city/london
```

and a request using GET, but here's the question: why get? Simple. Using GET, as we aren't passing any sensitive information, we can just write the params (in this case, the place we want to know the weather) in the request URL.
After making a request, it passes the params through the MetaWeather API and gets the information that was specified (celsius and farenheit) to show on the screen as a Json Object. While making the response methods, as the array was a Json Array and Java is a strongly typed language, Casting had to be used to transform the Json Array item that we wanted in a Json Object, so then we could handle this specified information from the body of it. Important: to deal with Json, a external library had to be used. Subsequently, after getting this item, we had to specify the name of the array and which item from it we wanted (with Casting), and following all this, we have the response we wanted.  


## How to use it?
First, in the URL of this repository of mine, after "github", write "1s", like this: 
```
https://github1s.com/barbisliboni/cityWeather
``` 
Doing it, this code will open in your IDE. After this, run the code, check the terminal to know if its already running, and write the following URL in wherever you want to test it (Postman, browser, Fiddler, etc): 
```
http://localhost:8080/weather/city/{location}
```
(By location, I mean the place you want to know the weather). 
### PS: Don't forget to use accent and space while writing it. 
### PS²: It will show only the main cities/states if you're seaching a place which is not in the USA. 
