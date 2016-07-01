package dev.zelenin.weather_informer.weather_context.weather_states;

/**
 * Created by victor on 01.07.16.
 */
public class Rain {
    private double rainVolume;
    private boolean isRain;

    public Rain(){

    }

    public Rain(double rainVolume, boolean isRain) {
        this.rainVolume = rainVolume;
        this.isRain = isRain;
    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }

    public boolean isRain() {
        return isRain;
    }

    public void setRain(boolean rain) {
        isRain = rain;
    }
}
