package dev.zelenin.weather_informer.weather_context;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 01.07.16.
 */
public class CurrentCondition implements Parcelable {
    private int weatherId;
    private String mainDescription;
    private String additionalDescription;
    private String imageCode;
    private int humidity;
    private double pressure;

    public CurrentCondition() {
    }

    public CurrentCondition(int weatherId, String mainDescription, String additionalDescription,
                            String imageCode, int humidity, double pressure) {
        this.weatherId = weatherId;
        this.mainDescription = mainDescription;
        this.additionalDescription = additionalDescription;
        this.imageCode = imageCode;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    protected CurrentCondition(Parcel in) {
        weatherId = in.readInt();
        mainDescription = in.readString();
        additionalDescription = in.readString();
        imageCode = in.readString();
        humidity = in.readInt();
        pressure = in.readDouble();
    }

    public static final Creator<CurrentCondition> CREATOR = new Creator<CurrentCondition>() {
        @Override
        public CurrentCondition createFromParcel(Parcel in) {
            return new CurrentCondition(in);
        }

        @Override
        public CurrentCondition[] newArray(int size) {
            return new CurrentCondition[size];
        }
    };

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "CurrentCondition{" +
                "weatherId=" + weatherId +
                ", mainDescription='" + mainDescription + '\'' +
                ", additionalDescription='" + additionalDescription + '\'' +
//                ", imageCode='" + imageCode + '\'' +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(weatherId);
        parcel.writeString(mainDescription);
        parcel.writeString(additionalDescription);
        parcel.writeString(imageCode);
        parcel.writeInt(humidity);
        parcel.writeDouble(pressure);
    }
}
