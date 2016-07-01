package dev.zelenin.weather_informer.weather_context.weather_states;

/**
 * Created by victor on 01.07.16.
 */
public class Clouds {
    private double cloudiness;

    public Clouds(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }
}
