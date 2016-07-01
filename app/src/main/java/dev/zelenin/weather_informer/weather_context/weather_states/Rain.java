package dev.zelenin.weather_informer.weather_context.weather_states;

/**
 * Created by victor on 01.07.16.
 */
public class Rain {
    private double rainVolume;

    public Rain() {

    }

    public Rain(double rainVolume) {
        this.rainVolume = rainVolume;

    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }
}
