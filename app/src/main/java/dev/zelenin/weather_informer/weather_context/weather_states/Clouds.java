package dev.zelenin.weather_informer.weather_context.weather_states;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class Clouds implements Parcelable {
    private double cloudiness;

    public Clouds() {
    }

    public Clouds(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    protected Clouds(Parcel in) {
        cloudiness = in.readDouble();
    }

    public static final Creator<Clouds> CREATOR = new Creator<Clouds>() {
        @Override
        public Clouds createFromParcel(Parcel in) {
            return new Clouds(in);
        }

        @Override
        public Clouds[] newArray(int size) {
            return new Clouds[size];
        }
    };

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "cloudiness=" + cloudiness +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(cloudiness);
    }
}

