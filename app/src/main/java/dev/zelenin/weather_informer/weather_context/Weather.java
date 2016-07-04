package dev.zelenin.weather_informer.weather_context;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import dev.zelenin.weather_informer.weather_context.weather_states.Clouds;
import dev.zelenin.weather_informer.weather_context.weather_states.Rain;
import dev.zelenin.weather_informer.weather_context.weather_states.Snow;
import dev.zelenin.weather_informer.weather_context.weather_states.Wind;

/**
 * Created by victor on 01.07.16.
 */
// TODO implement Parcelable!!!
public class Weather implements Parcelable {
    private Location location;
    private CurrentCondition currentCondition;
    private Temperature temperature;
    private Clouds clouds;
    private Wind wind;
    private boolean isRain;
    private Rain rain;
    private boolean isSnow;
    private Snow snow;

    private byte[] image;
    private Bitmap bitmap;

    public Weather() {
    }

    public Weather(Location location, CurrentCondition currentCondition,
                   Temperature temperature, Clouds clouds, Wind wind, Rain rain, Snow snow) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.clouds = clouds;
        this.wind = wind;
        if (rain != null) {
            this.rain = rain;
            isRain = true;
        }

        if (snow != null) {
            this.snow = snow;
            isSnow = true;
        }
    }

    public Weather(Parcel in) {
        location = in.readParcelable(Location.class.getClassLoader());
        currentCondition = in.readParcelable(CurrentCondition.class.getClassLoader());
        temperature = in.readParcelable(Temperature.class.getClassLoader());
        clouds = in.readParcelable(Clouds.class.getClassLoader());
        wind = in.readParcelable(Wind.class.getClassLoader());
        isRain = in.readByte() != 0;
        rain = in.readParcelable(Rain.class.getClassLoader());
        isSnow = in.readByte() != 0;
        snow = in.readParcelable(Snow.class.getClassLoader());
        image = in.createByteArray();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public boolean isRain() {
        return isRain;
    }

    public void setRain(boolean rain) {
        isRain = rain;
    }

    public boolean isSnow() {
        return isSnow;
    }

    public void setSnow(boolean snow) {
        isSnow = snow;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(location, flags);
        parcel.writeParcelable(currentCondition, flags);
        parcel.writeParcelable(temperature, flags);
        parcel.writeParcelable(clouds, flags);
        parcel.writeParcelable(wind, flags);
        parcel.writeByte((byte) (isRain ? 1 : 0));
        parcel.writeParcelable(rain, flags);
        parcel.writeByte((byte) (isSnow ? 1 : 0));
        parcel.writeParcelable(snow, flags);
        parcel.writeByteArray(image);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "location=" + location +
                ", currentCondition=" + currentCondition +
                ", temperature=" + temperature +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", isRain=" + isRain +
//                ", rain=" + rain +
                ", isSnow=" + isSnow +
//                ", snow=" + snow +
                '}';
    }

}
