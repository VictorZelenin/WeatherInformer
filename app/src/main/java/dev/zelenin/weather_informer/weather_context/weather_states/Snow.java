package dev.zelenin.weather_informer.weather_context.weather_states;

/**
 * Created by victor on 01.07.16.
 */
public class Snow {
    private boolean isSnow;
    private double snowVolume;

    public Snow() {

    }

    public Snow(boolean isSnow, double snowVolume) {
        this.isSnow = isSnow;
        this.snowVolume = snowVolume;
    }

    public boolean isSnow() {
        return isSnow;
    }

    public void setSnow(boolean snow) {
        isSnow = snow;
    }

    public double getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(double snowVolume) {
        this.snowVolume = snowVolume;
    }
}
