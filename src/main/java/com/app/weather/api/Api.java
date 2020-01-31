package com.app.weather.api;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Api {
    private static final String OPEN_WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String OPEN_WEATHER_KEY = "&units=metric&APPID=172989e0fdbd7e665e25527fcd18c9f0";
    private  static final  String WEATHER_STACK_BASE_URL = "http://api.weatherstack.com/current?access_key=64a92dfd1a6e1944943941f73e33d99b&query=";

    private static String getOpenWeatherBaseUrl(String city) {
        return OPEN_WEATHER_BASE_URL + city + OPEN_WEATHER_KEY;
    }

    private static String getWeatherStackBaseUrl(String city) {
        return WEATHER_STACK_BASE_URL + city;
    }

    private static String makeResponse(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }

    public static String getWeatherJson(String city, String service) throws IOException {
        String serviceUrl;
        if (service.equals(NameServices.OPEN_WEATHER.getServiceName())) {
            serviceUrl = getOpenWeatherBaseUrl(city);
        }else if (service.equals(NameServices.STACK_WEATHER.getServiceName())) {
            serviceUrl = getWeatherStackBaseUrl(city);
        } else {
            return "Check the name of the weather service";
        }
        return makeResponse(serviceUrl);
    }

    public static String getOpenWeatherJson(String city) throws IOException {
        return makeResponse(getOpenWeatherBaseUrl(city));
    }

    public static String getStackWeatherJson(String city) throws IOException {
        return makeResponse(getWeatherStackBaseUrl(city));
    }



}
