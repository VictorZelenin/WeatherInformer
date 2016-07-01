package dev.zelenin.weather_informer.weather_context;

/**
 * Created by victor on 01.07.16.
 */
public class Temperature {
    private double averageTemperature;
    private double minTemperature;
    private double maxTemperature;

    public Temperature() {
    }

    public Temperature(double averageTemperature, double minTemperature, double maxTemperature) {
        this.averageTemperature = averageTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
