package dev.zelenin.weather_informer.weather_context;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class GeographicCoordinates implements Parcelable {
    private double latitude; // широта
    private double longitude; // довгота

    protected GeographicCoordinates(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GeographicCoordinates> CREATOR = new Creator<GeographicCoordinates>() {
        @Override
        public GeographicCoordinates createFromParcel(Parcel in) {
            return new GeographicCoordinates(in);
        }

        @Override
        public GeographicCoordinates[] newArray(int size) {
            return new GeographicCoordinates[size];
        }
    };

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
