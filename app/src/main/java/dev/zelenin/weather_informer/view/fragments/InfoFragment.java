package dev.zelenin.weather_informer.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.zelenin.weather_informer.R;
import dev.zelenin.weather_informer.weather_context.Weather;

import static dev.zelenin.weather_informer.view.fragments.CurrentWeatherFragment.validateTemperature;

/**
 * Created by victor on 02.07.16.
 */
public class InfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedState) {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        Weather weather = getArguments().getParcelable("weather");

        TextView cityName = (TextView) getView().findViewById(R.id.i_city);
        TextView countryName = (TextView) getView().findViewById(R.id.i_country);
        TextView temperature = (TextView) getView().findViewById(R.id.i_temp);
        TextView humidity = (TextView) getView().findViewById(R.id.i_humidity);
        TextView pressure = (TextView) getView().findViewById(R.id.i_pressure);
        TextView clouds = (TextView) getView().findViewById(R.id.i_clouds);
        TextView windSpeed = (TextView) getView().findViewById(R.id.i_windspeed);
        TextView description = (TextView) getView().findViewById(R.id.i_description);

        cityName.setText(weather.getLocation().getCityName());
        countryName.setText(weather.getLocation().getCountryName());
        temperature.setText(validateTemperature(weather.getTemperature().getAverageTemperature()) + ", " +
                validateTemperature(weather.getTemperature().getMinTemperature()) + ", " +
                validateTemperature(weather.getTemperature().getMaxTemperature()));
        humidity.setText(String.valueOf(weather.getCurrentCondition().getHumidity()));
        pressure.setText(String.valueOf(weather.getCurrentCondition().getPressure()));
        clouds.setText(String.valueOf(weather.getClouds().getCloudiness()));
        windSpeed.setText(String.valueOf(weather.getWind().getWindSpeed()));
        description.setText(weather.getCurrentCondition().getAdditionalDescription());
    }
}
