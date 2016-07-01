package dev.zelenin.weather_informer.weather_context;

/**
 * Created by victor on 01.07.16.
 */
public class Location {
    private GeographicCoordinates coordinates;
    private String countryName;
    private String cityName;
    private long sunrise;
    private long sunset;

    public Location(){}

    public Location(GeographicCoordinates coordinates, String countryName,
                    String cityName, long sunrise, long sunset) {
        this.coordinates = coordinates;
        this.countryName = countryName;
        this.cityName = cityName;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public GeographicCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(GeographicCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}
