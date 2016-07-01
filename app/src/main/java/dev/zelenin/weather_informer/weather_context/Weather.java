package dev.zelenin.weather_informer.weather_context;

import dev.zelenin.weather_informer.weather_context.weather_states.Clouds;
import dev.zelenin.weather_informer.weather_context.weather_states.Rain;
import dev.zelenin.weather_informer.weather_context.weather_states.Snow;
import dev.zelenin.weather_informer.weather_context.weather_states.Wind;

/**
 * Created by victor on 01.07.16.
 */
public class Weather {
    private Location location;
    private CurrentCondition currentCondition;
    private Temperature temperature;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Snow snow;

    public Weather() {
    }

    public Weather(Location location, CurrentCondition currentCondition,
                   Temperature temperature, Clouds clouds, Wind wind, Rain rain, Snow snow) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.snow = snow;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }
}