package dev.zelenin.weather_informer.weather_context.weather_states;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class Snow implements Parcelable {
    private double snowVolume;

    public Snow() {
    }

    public Snow(double snowVolume) {
        this.snowVolume = snowVolume;
    }

    protected Snow(Parcel in) {
        snowVolume = in.readDouble();
    }

    public static final Creator<Snow> CREATOR = new Creator<Snow>() {
        @Override
        public Snow createFromParcel(Parcel in) {
            return new Snow(in);
        }

        @Override
        public Snow[] newArray(int size) {
            return new Snow[size];
        }
    };

    public double getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(double snowVolume) {
        this.snowVolume = snowVolume;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(snowVolume);
    }
}
