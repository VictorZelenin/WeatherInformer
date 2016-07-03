package dev.zelenin.weather_informer.weather_context.weather_states;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class Wind implements Parcelable {
    private double windSpeed;
    private double windDirection;

    public Wind() {
    }

    public Wind(double windSpeed, double windDirection) {
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    protected Wind(Parcel in) {
        windSpeed = in.readDouble();
        windDirection = in.readDouble();
    }

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(windSpeed);
        parcel.writeDouble(windDirection);
    }
}
