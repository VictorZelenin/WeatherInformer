package dev.zelenin.weather_informer.weather_context.weather_states;

/**
 * Created by victor on 01.07.16.
 */
public class Wind {
    private double windSpeed;
    private double windDirection;

    public Wind() {
    }

    public Wind(double windSpeed, double windDirection) {
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }
}
