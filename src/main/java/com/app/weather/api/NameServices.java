package com.app.weather.api;

public enum NameServices {
    OPEN_WEATHER("openWeather"), STACK_WEATHER("stackWeather");

    private String serviceName;

    NameServices(String service){
        this.serviceName = service;
    }

    public String getServiceName(){
        return this.serviceName;
    }


}
