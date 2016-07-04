package dev.zelenin.weather_informer.view.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import dev.zelenin.weather_informer.R;
import dev.zelenin.weather_informer.weather_context.Weather;

/**
 * Created by victor on 02.07.16.
 */
public class CurrentWeatherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedState) {
        return inflater.inflate(R.layout.current_condition_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        TextView cityName = (TextView) getView().findViewById(R.id.city_name);
        TextView averageTemperature = (TextView) getView().findViewById(R.id.avg_temp);
        TextView minMaxTemperature = (TextView) getView().findViewById(R.id.min_max_temp);
        TextView description = (TextView) getView().findViewById(R.id.description);
        TextView humidity = (TextView) getView().findViewById(R.id.humidity);
        TextView pressure = (TextView) getView().findViewById(R.id.pressure);

        ImageView weatherIcon = (ImageView) getView().findViewById(R.id.weather_icon);

        Weather weather = (Weather) getArguments().get("weather");

        cityName.setText(weather.getLocation().getCityName());
        averageTemperature.setText(validateTemperature(weather.getTemperature().getAverageTemperature()));
        description.setText(weather.getCurrentCondition().getAdditionalDescription());
        minMaxTemperature.setText(validateTemperature(weather.getTemperature().getMinTemperature())
                + "  " + validateTemperature(weather.getTemperature().getMaxTemperature()));
        humidity.setText("humidity: " + weather.getCurrentCondition().getHumidity());
        pressure.setText("pressure: " + weather.getCurrentCondition().getPressure());

        // TODO returns null
        Bitmap bitmap = BitmapFactory.decodeByteArray(weather.getImage(), 0, weather.getImage().length);
        System.out.println(bitmap);
        weatherIcon.setImageBitmap(bitmap);
    }

    private String validateTemperature(double temperature) {
        double value = temperature - 273.0;
        return String.format("%.2f", value);
    }
}
