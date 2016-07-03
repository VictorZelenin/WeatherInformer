package dev.zelenin.weather_informer.weather_context.weather_states;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class Rain implements Parcelable {
    private double rainVolume;

    public Rain() {

    }

    public Rain(double rainVolume) {
        this.rainVolume = rainVolume;

    }

    protected Rain(Parcel in) {
        rainVolume = in.readDouble();
    }

    public static final Creator<Rain> CREATOR = new Creator<Rain>() {
        @Override
        public Rain createFromParcel(Parcel in) {
            return new Rain(in);
        }

        @Override
        public Rain[] newArray(int size) {
            return new Rain[size];
        }
    };

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(rainVolume);
    }
}
