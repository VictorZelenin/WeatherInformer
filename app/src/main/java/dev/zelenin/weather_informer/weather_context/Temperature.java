package dev.zelenin.weather_informer.weather_context;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class Temperature implements Parcelable {
    private double averageTemperature;
    private double minTemperature;
    private double maxTemperature;

    public Temperature() {
    }

    public Temperature(double averageTemperature, double minTemperature, double maxTemperature) {
        this.averageTemperature = averageTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    protected Temperature(Parcel in) {
        averageTemperature = in.readDouble();
        minTemperature = in.readDouble();
        maxTemperature = in.readDouble();
    }

    public static final Creator<Temperature> CREATOR = new Creator<Temperature>() {
        @Override
        public Temperature createFromParcel(Parcel in) {
            return new Temperature(in);
        }

        @Override
        public Temperature[] newArray(int size) {
            return new Temperature[size];
        }
    };

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "averageTemperature=" + averageTemperature +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(averageTemperature);
        parcel.writeDouble(minTemperature);
        parcel.writeDouble(maxTemperature);
    }
}
