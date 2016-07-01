package dev.zelenin.weather_informer.weather_context;

/**
 * Created by victor on 01.07.16.
 */
public class CurrentCondition {
    private int weatherId;
    private String mainDescription;
    private String additionalDescription;
    private String imageCode;
    private int humidity;
    private double pressure;

    public CurrentCondition() {
    }

    public CurrentCondition(int weatherId, String mainDescription, String additionalDescription,
                            String imageCode, int humidity, double pressure) {
        this.weatherId = weatherId;
        this.mainDescription = mainDescription;
        this.additionalDescription = additionalDescription;
        this.imageCode = imageCode;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

}
