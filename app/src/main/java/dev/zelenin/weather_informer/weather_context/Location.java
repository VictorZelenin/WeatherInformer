package dev.zelenin.weather_informer.weather_context;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class Location implements Parcelable {
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

    protected Location(Parcel in) {
        coordinates = in.readParcelable(GeographicCoordinates.class.getClassLoader());
        countryName = in.readString();
        cityName = in.readString();
        sunrise = in.readLong();
        sunset = in.readLong();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

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

    @Override
    public String toString() {
        return "Location{" +
                "coordinates=" + coordinates +
                ", countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(coordinates, i);
        parcel.writeString(countryName);
        parcel.writeString(cityName);
        parcel.writeLong(sunrise);
        parcel.writeLong(sunset);
    }
}
