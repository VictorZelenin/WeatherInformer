package dev.zelenin.weather_informer.weather_context;

/**
 * Created by victor on 01.07.16.
 */
public class GeographicCoordinates {
    private double latitude; // широта
    private double longitude; // довгота

    public double getLatitude() {
        return latitude;
    }

    public GeographicCoordinates(){
        latitude = 51.28d;
        longitude = 0.0d;
    }

    public GeographicCoordinates(double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeographicCoordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
