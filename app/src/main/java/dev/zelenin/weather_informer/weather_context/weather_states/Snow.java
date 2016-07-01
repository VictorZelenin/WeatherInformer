package dev.zelenin.weather_informer.weather_context.weather_states;

/**
 * Created by victor on 01.07.16.
 */
public class Snow {
    private double snowVolume;

    public Snow() {
    }

    public Snow(double snowVolume) {
        this.snowVolume = snowVolume;
    }

    public double getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(double snowVolume) {
        this.snowVolume = snowVolume;
    }
}
